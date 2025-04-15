package com.lizhengpeng.bigger.java;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.List;


@Intercepts(
        {
                @Signature(
                        type = ResultSetHandler.class,
                        method = "handleResultSets",
                        args = {Statement.class}
                )
        }
)
public class ResultSetInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List list = (List) invocation.proceed();

        return list;
    }

}
