package com.lizhengpeng.bigger.java;

import com.lizhengpeng.bigger.java.exception.NestedJarException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static com.lizhengpeng.bigger.java.NestedLauncher.NESTED_APP;
import static com.lizhengpeng.bigger.java.NestedLauncher.NESTED_LIB;
import static com.lizhengpeng.bigger.java.jar.Handler.SEPARATOR;

public class NestedURLConnection extends URLConnection {

    private File locateJar;

    public NestedURLConnection(URL url, File locateJar) throws IOException {
        super(url);
        this.locateJar = locateJar;
    }

    @Override
    public void connect() throws IOException {
        if (!locateJar.exists()) {
            throw new NestedJarException("The locatejar file does not exist");
        }
    }

    @Override
    public InputStream getInputStream() throws IOException {
        ZipFile zipFile = new ZipFile(locateJar);
        return getInputStream(zipFile, url);
    }

    private InputStream getInputStream(ZipFile zipFile, URL url) throws IOException {
        String urlPath = url.getPath();
        if (urlPath.contains(NESTED_LIB)) {
            return getInputStreamByBootLib(zipFile, url);
        } else if (urlPath.contains(NESTED_APP)) {
            return getInputStreamByAppLib(zipFile, url);
        }
        throw new NestedJarException("Invalid embedded jar URL");
    }

    private InputStream getInputStreamByAppLib(ZipFile zipFile, URL url) throws IOException {
        String urlPath = url.getPath();
        int index = urlPath.lastIndexOf(SEPARATOR);
        if (index == -1) {
            throw new NestedJarException("Invalid app path pattern");
        }
        String resource = urlPath.substring(index + SEPARATOR.length());
        ZipEntry zipEntry = zipFile.getEntry(NESTED_APP + resource);
        if (zipEntry != null) {
            return zipFile.getInputStream(zipEntry);
        }
        throw new IllegalStateException("Failed to load resource");
    }

    private InputStream getInputStreamByBootLib(ZipFile zipFile, URL url) throws IOException {
        String urlPath = url.getPath();
        // 首先提取具体的JAR包
        String[] component = urlPath.split(SEPARATOR);
        if (component.length != 3) {
            throw new NestedJarException("Invalid jar path pattern");
        }
        // 提取JAR包数据
        String jarPkg = component[1];
        /**
         * 将zip中的entry数据转换成JAR包数据
         * jar包的名称对应zip中的一个entry信息
         */
        ZipEntry entry = zipFile.getEntry(jarPkg);
        if (entry == null) {
            throw new NestedJarException("Invalid jar entry");
        }
        // 资源名称
        String resource = component[2];
        // 提取资源的名称
        ZipEntry jarEntry;
        JarInputStream inputStream = new JarInputStream(zipFile.getInputStream(entry));
        while ((jarEntry = inputStream.getNextEntry()) != null) {
            if (jarEntry.getName().equals(resource)) {
                return inputStream;
            }
        }
        throw new IllegalStateException("Failed to load resource");
    }

}
