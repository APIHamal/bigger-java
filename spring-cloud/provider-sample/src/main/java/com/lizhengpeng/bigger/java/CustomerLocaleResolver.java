package com.lizhengpeng.bigger.java;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 自定义的区域语言选择器
 * 根据请求头中的locale字段优先来确定用户所处的环境
 *
 * @author lzp
 * @since 2025-05-10
 */
@Component("localeResolver")
public class CustomerLocaleResolver extends AcceptHeaderLocaleResolver {

    private static final Map<String, Locale> localeMap = new HashMap<>(4);

    static {
        localeMap.put("en", Locale.US);
        localeMap.put("zh", Locale.CHINESE);
    }

    /**
     * 自定义选择逻辑（具体流程参考DispatcherServlet#buildLocaleContext）
     * @param request the request to resolve the locale for
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String locale = request.getHeader("locale");
        if (locale != null) {
            Locale supportLocale = localeMap.get(locale.toLowerCase(Locale.US));
            if (supportLocale != null) {
                return supportLocale;
            }
        }
        return super.resolveLocale(request);
    }

}
