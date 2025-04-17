package com.lizhengpeng.bigger.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StopWatch;


@Intercepts(
        {
                @Signature(
                        type = Executor.class,
                        method = "query",
                        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
                )
        }
)
@Slf4j
public class StatsInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StopWatch timeWatch = new StopWatch("SQL Execute Time Watch");
        timeWatch.start();
        try {
            return invocation.proceed();
        } finally {
            timeWatch.stop();
            log.info("{}执行耗时{}毫秒", timeWatch.getId(), timeWatch.getTotalTimeMillis());
        }

    }

}
