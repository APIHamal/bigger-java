package com.lizhengpeng.bigger.java;

import com.lizhengpeng.bigger.java.jar.Handler;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static com.lizhengpeng.bigger.java.jar.Handler.SEPARATOR;

public class NestedLauncher {

    public static final String NESTED_LIB = "NESTED_LIB/";

    public static final String NESTED_APP = "NESTED_APP/";

    /**
     * 嵌入式启动程序入口
     */
    public void nestedRun() throws Exception {
        File locateJar = this.locateJar();
        this.nestedRun(locateJar);
    }

    /**
     * 嵌入式启动程序入口
     */
    public void nestedRun(File locateJar) throws Exception {
        List<URL> nestedURL = new ArrayList<>();
        try (ZipFile zipFile = new ZipFile(locateJar)) {
            // 自定义的协议处理器
            Handler jarHandler = new Handler(locateJar);
            // 获取嵌入式JAR包的url
            getNestedJarURL(nestedURL, jarHandler, zipFile, locateJar, new EntryFilter() {
                @Override
                public boolean filter(ZipEntry entry) {
                    return entry.getName().startsWith(NESTED_LIB) && !entry.getName().equalsIgnoreCase(NESTED_LIB);
                }
            });
            // 获取app的url
            getNestedAppURL(nestedURL, jarHandler, zipFile, locateJar, new EntryFilter() {
                @Override
                public boolean filter(ZipEntry entry) {
                    return entry.getName().equalsIgnoreCase(NESTED_APP);
                }
            });
        }
        NestedJarClassLoader nestedClassLoader = new NestedJarClassLoader(nestedURL.toArray(new URL[0]), NestedLauncher.class.getClassLoader());
        Thread.currentThread().setContextClassLoader(nestedClassLoader);
    }

    /**
     * 获取当前所处的JAR包的位置
     *
     * @return
     * @throws Exception
     */
    private File locateJar() throws Exception {
        ProtectionDomain protectionDomain = getClass().getProtectionDomain();
        CodeSource codeSource = protectionDomain.getCodeSource();
        URI location = (codeSource != null) ? codeSource.getLocation().toURI() : null;
        String path = (location != null) ? location.getSchemeSpecificPart() : null;
        if (path == null) {
            throw new IllegalStateException("Unable to determine code source archive");
        }
        File locateJar = new File(path);
        if (!locateJar.exists() || !locateJar.isFile() || !locateJar().canRead()) {
            throw new IllegalStateException("Unable to determine code source archive from " + locateJar);
        }
        return locateJar;
    }

    /**
     * 获取嵌入式JAR的URL
     *
     * @param nestedURL
     * @param nestedJarHandler
     * @param zipFile
     * @param jarFile
     * @param filter
     * @return
     * @throws Exception
     */
    private void getNestedJarURL(List<URL> nestedURL, Handler nestedJarHandler, ZipFile zipFile, File jarFile, EntryFilter filter) throws Exception {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            if (filter.filter(zipEntry)) {
                String nestedPath = jarFile.toURI().toURL() + SEPARATOR + zipEntry.getName() + SEPARATOR;
                URL url = new URL("jar", null, -1, nestedPath, nestedJarHandler);
                nestedURL.add(url);
            }
        }
    }

    /**
     * 获取嵌入式的APP目录
     *
     * @param nestedURL
     * @param nestedJarHandler
     * @param zipFile
     * @param jarFile
     * @param filter
     * @throws Exception
     */
    private void getNestedAppURL(List<URL> nestedURL, Handler nestedJarHandler, ZipFile zipFile, File jarFile, EntryFilter filter) throws Exception {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            if (filter.filter(zipEntry)) {
                String nestedPath = jarFile.toURI().toURL() + SEPARATOR + NESTED_APP + SEPARATOR;
                URL url = new URL("jar", null, -1, nestedPath, nestedJarHandler);
                nestedURL.add(url);
            }
        }
    }

    public interface EntryFilter {
        default boolean filter(ZipEntry entry) {
            return false;
        }

    }

    public static class NestedJarClassLoader extends URLClassLoader {

        public NestedJarClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }
    }

}
