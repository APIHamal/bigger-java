package com.lizhengpeng.bigger.java;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义ReturnValueHandler对象
 * 仅仅是一个标记接口
 * @author lzp
 * @since 2025-05-10
 */
@Slf4j
public class EasyStream implements AsyncListener {

    public static final String EASY_STREAM_RESULT_ATTRIBUTE = "EASY_STREAM_RESULT_ATTRIBUTE";

    private HttpServletRequest request;

    private HttpServletResponse response;

    private AsyncContext asyncContext;

    private long timeout = 1000 * 5;

    public EasyStream(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        startAsyncContext();
    }

    private void startAsyncContext() {
        if (!request.isAsyncSupported()) {
            throw new IllegalStateException("Servlet not support async");
        }
        try {
            asyncContext = request.startAsync(request, response);
            asyncContext.setTimeout(timeout);
            asyncContext.addListener(this);
        } catch (Exception e) {
            try {
                asyncContext.complete();
            } catch (Exception ignore) {}
            throw new EasyStreamException("apply easy stream exception", e);
        }
    }


    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        log.info("easy stream completed");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        onError(new TimeoutException("easy stream timeout"));
    }

    public void writeTo(String context) {
        try {
            response.getWriter().write(context);
        } catch (Exception e) {
            onError(e);
        }
    }

    public void flush() {
        try {
            response.getWriter().flush();
        } catch (Exception e) {
            onError(e);
        } finally {
            try {
                asyncContext.complete();
            } catch (Exception ignore) {}
        }
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        Throwable throwable = event.getThrowable();
        onError(throwable);
    }

    private void onError(Throwable throwable) {
        if (throwable == null) {
            throwable = new UnKnowException("easy stream un know exception");
        }
        request.setAttribute(EASY_STREAM_RESULT_ATTRIBUTE, throwable);
        try {
            asyncContext.dispatch();
        } catch (Exception ignore) {}
    }

    public void errorTo(Throwable throwable) {
        onError(throwable);
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
    }

    /**
     * 流超时异常
     */
    public static class TimeoutException extends RuntimeException {
        public TimeoutException(String msg) {
            super(msg);
        }
    }

    /**
     * 流超时异常
     */
    public static class UnKnowException extends RuntimeException {
        public UnKnowException(String msg) {
            super(msg);
        }
    }

    /**
     * 流超时异常
     */
    public static class EasyStreamException extends RuntimeException {
        public EasyStreamException(String msg, Exception e) {
            super(msg, e);
        }
    }

}
