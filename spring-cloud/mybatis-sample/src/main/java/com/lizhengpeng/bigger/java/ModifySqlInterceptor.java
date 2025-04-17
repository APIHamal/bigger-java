package com.lizhengpeng.bigger.java;

import com.alibaba.nacos.common.utils.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.CallableStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;


@Intercepts(
        {
                @Signature(
                        type = StatementHandler.class,
                        method = "prepare",
                        args = {Connection.class, Integer.class}
                )
        }
)
@SuppressWarnings("all")
@Slf4j
public class ModifySqlInterceptor implements Interceptor {

    private static final String DELEGATE_FIELD_NAME = "delegate";

    private static final Field DELEGATE_FIELD;

    private static final String CONFIGURATION_NAME = "configuration";

    private static final Field CONFIGURATION;

    private static final String BOUNDSQL_NAME = "boundSql";

    private static final Field BOUNDSQL;

    private static final String SELECT_PREFIX = "select";

    static {
        try {
            DELEGATE_FIELD = RoutingStatementHandler.class.getDeclaredField(DELEGATE_FIELD_NAME);
            DELEGATE_FIELD.setAccessible(true);

            CONFIGURATION = BaseStatementHandler.class.getDeclaredField(CONFIGURATION_NAME);
            CONFIGURATION.setAccessible(true);

            BOUNDSQL = BaseStatementHandler.class.getDeclaredField(BOUNDSQL_NAME);
            BOUNDSQL.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch("SQL Modify Plugin");
        stopWatch.start();

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        // 修改SQL
        if (!StringUtils.isEmpty(sql) && sql.toLowerCase(Locale.ENGLISH).contains(SELECT_PREFIX)) {
            Statement statement = CCJSqlParserUtil.parse(boundSql.getSql());
            modifySelect((Select) statement);
            // 修改后的SQL
            String newSQl = statement.toString();

            // 返回mybatis中的configuration对象
            Configuration configuration = null;
            if (statementHandler instanceof RoutingStatementHandler) {
                StatementHandler delegate = (StatementHandler) DELEGATE_FIELD.get(statementHandler);
                // 不修改存储过程
                if (delegate instanceof CallableStatementHandler) {
                    return invocation.proceed();
                } else {
                    statementHandler = delegate;
                    configuration = (Configuration) CONFIGURATION.get(delegate);
                }
            }

            // 返回修改后的SQL
            BoundSql newBoundSql = new BoundSql(configuration, newSQl, boundSql.getParameterMappings(), boundSql.getParameterObject());
            BOUNDSQL.set(statementHandler, newBoundSql);
        }

        stopWatch.stop();
        log.info("{}执行耗时{}毫秒", stopWatch.getId(), stopWatch.getTotalTimeMillis());
        return invocation.proceed();
    }

    private static EqualsTo getExtraEquals(Table table) {
        // 增加一个测试的where条件
        EqualsTo tenant = new EqualsTo();
        tenant.setLeftExpression(new Column(table,"id"));
        tenant.setRightExpression(new LongValue("1"));
        return tenant;
    }

    private static void modifySelect(Select select) {
        if (select instanceof PlainSelect) {
            PlainSelect plainSelect = select.getPlainSelect();
            FromItem fromItem = plainSelect.getFromItem();
            if (fromItem instanceof Table) {
                Expression where = plainSelect.getWhere();
                if (where == null) {
                    plainSelect.setWhere(getExtraEquals((Table) fromItem));
                } else {
                    // 原有WHERE存在,用AND连接
                    Parenthesis existingParenthesis = new Parenthesis(where);
                    AndExpression combined = new AndExpression(existingParenthesis, getExtraEquals((Table) fromItem));
                    plainSelect.setWhere(combined);
                }
            }
            // 处理SQL中的Join关系
            List<Join> joins = plainSelect.getJoins();
            if (CollectionUtils.isNotEmpty(joins)) {
                joins.forEach(ModifySqlInterceptor::modifySqlJoin);
            }
            // 处理SQL子查询
            if (fromItem instanceof ParenthesedSelect) {
                ParenthesedSelect parenthesedSelect = (ParenthesedSelect) fromItem;
                modifySelect(parenthesedSelect.getSelect());
            }
        } else if (select instanceof SetOperationList) {
            SetOperationList setOperationList = (SetOperationList) select;
            setOperationList.getSelects().forEach(ModifySqlInterceptor::modifySelect);
        }
    }

    private static void modifySqlJoin(Join join) {
        if (join == null) {
            return;
        }
        FromItem fromItem = join.getFromItem();
        if (fromItem instanceof Table) {
            ExpressionList expressionList = new ExpressionList(join.getOnExpressions());
            Parenthesis existingParenthesis = new Parenthesis(expressionList);
            AndExpression combined = new AndExpression(existingParenthesis, getExtraEquals((Table) fromItem));
            join.setOnExpressions(Collections.singleton(combined));
        } else if (fromItem instanceof Select) {
            modifySelect((Select) fromItem);
        }
    }

}
