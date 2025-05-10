package com.lizhengpeng.bigger.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestController
public class ProviderApplication {

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
