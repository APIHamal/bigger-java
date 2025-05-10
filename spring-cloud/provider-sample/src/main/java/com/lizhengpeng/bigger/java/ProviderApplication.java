package com.lizhengpeng.bigger.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestController
@Slf4j
public class ProviderApplication {

    private static final String ASYNC_CONTEXT_ATTRIBUTE = "ASYNC_CONTEXT_ATTRIBUTE";

    @Resource
    private HelloComponent helloComponent;

    @Resource
    private MessageSource messageSource;

    @GetMapping("/hello-component")
    public String helloComponent() {
        return helloComponent.getHello();
    }

    @GetMapping("/hello")
    public String welcome(HttpServletRequest request) {
        String header = request.getHeader("X-TRACE-ID");
        return "welcome, baby! TraceId:" + header;
    }

    @GetMapping("/deferred")
    public DeferredResult<String> deferred(HttpServletResponse response) {
        DeferredResult<String> deferredResult = new DeferredResult<>( 10 * 1000l, () -> "接口发生了超时");
        new Thread(() -> {
            try {
                Thread.sleep(1000 * 2);
                // 设置结果后，Spring会自动将结果写入响应
                if (deferredResult.isSetOrExpired()) {
                    System.out.println("发生了超时了?");
                    return;
                }
                deferredResult.setResult("测试");
            } catch (Exception e) {
                deferredResult.setErrorResult(e);
            }
        }).start();
        return deferredResult;
    }

    @GetMapping("/servlet-deferred")
    public void servletDeferred(HttpServletRequest request, HttpServletResponse response) {
        AsyncContext asyncContext = (AsyncContext) request.getAttribute(ASYNC_CONTEXT_ATTRIBUTE);
        try {
            // 已经开启了异步的支持
            if (asyncContext != null) {
                response.setStatus(200);
                response.getWriter().write("this is servlet deferred");
                response.getWriter().flush();
                return;
            }
        } catch (Exception e) {
            log.error("servlet deferred exception", e);
            return;
        }
        asyncContext = request.startAsync(request, response);
        AsyncContext finalContext = asyncContext;
        new Thread(() -> {
            try {
                Thread.sleep(1000 * 2);
                // dispatch表示重新分发请求
                // 调用了dispatch之后会【重新进入到/servlet-deferred】
                finalContext.dispatch();
                request.setAttribute(ASYNC_CONTEXT_ATTRIBUTE, finalContext);
            } catch (Exception e) {
                log.error("async deferred exception", e);
            }
        }).start();
    }

    @GetMapping("/easy-stream")
    public void servletDeferred(EasyStream easyStream, String error) {
        new Thread(() -> {
            try {
                for (int index = 0; index < 5; index++) {
                    easyStream.writeTo("hello world");
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {}
                    // 触发异常
                    if (StringUtils.isNotBlank(error)) {
                        easyStream.errorTo(new RuntimeException("测试异常的触发"));
                    }
                }
                easyStream.flush();
            } catch (Exception e) {
                log.error("async deferred exception", e);
            }
        }).start();
    }

    @GetMapping("/hello-by-locale")
    public String helloLocale(Locale locale) {
        return messageSource.getMessage("welcome.message", null, locale);
    }

    @GetMapping("/hello/json")
    @ResponseBody
    public Map<String, Object> welcomeJson(HttpServletRequest request) {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "lizhengpeng");
        user.put("age", 20);
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
