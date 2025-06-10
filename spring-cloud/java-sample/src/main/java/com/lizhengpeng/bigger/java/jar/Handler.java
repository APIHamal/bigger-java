package com.lizhengpeng.bigger.java.jar;

import com.lizhengpeng.bigger.java.NestedLauncher;
import com.lizhengpeng.bigger.java.NestedURLConnection;
import com.lizhengpeng.bigger.java.exception.NestedJarException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler extends URLStreamHandler {

    public static final String SEPARATOR = "!/";

    private final File locateJar;

    public Handler(File locateJar) {
        this.locateJar = locateJar;
    }

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        return new NestedURLConnection(url, locateJar);
    }

    @Override
    protected void parseURL(URL context, String spec, int start, int limit) {
        /**
         * new URL()的过程中也会调用对应的Handler来处理当前的URL
         * 因此这里判断的作用是排除在NestedLauncher#nestedRun()
         * 的阶段加载到的两个初始的URL
         */
        if (spec == null || spec.isEmpty() || (spec.contains(NestedLauncher.NESTED_APP) || spec.contains(NestedLauncher.NESTED_LIB))) {
            return;
        }
        /**
         * URLClassLoader委托URLClassPath加载资源的时候(URLClassPath对象会遍历所有的【URL】尝试来加载资源)
         * 对于自定义handler或者自定义url协议的URL对象
         * URLClassPath对尝试以【当前的URL(指初始化URLClassLoader传入到URLClassPath中的URL对象)】
         * 作为父URL来构建子URL对象【然后返回子URL对象的URLConnection来返回资源】
         * 例如 new URL(context【构造URLClassLoader的时候传入的一系列URL】, spec【子URL(实际上是各个资源的名称)】)创建新的URL
         * 然后返回这个新的URL的【URLConnection】对象
         * 所以这里的【spec】实际上是资源名称【例如class名称等等】
         */
        String contextPath = context.toString();
        if (!contextPath.contains(NestedLauncher.NESTED_APP) && !contextPath.contains(NestedLauncher.NESTED_LIB)) {
            throw new NestedJarException("Invalid embedded jar URL");
        }
        contextPath = contextPath.replace("jar:","");
        String childrenURL = contextPath + spec;
        setURL(context, context.getProtocol(), "", -1, childrenURL, null);
    }
}
