import cn.hutool.core.io.IoUtil;
import com.lizhengpeng.bigger.java.NestedLauncher;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class NestedJarTest {
    public static void main(String[] args) throws Exception {
        File nestedJar = new File("C:\\Users\\zheng\\Desktop\\nested.jar");
        // 读取嵌入式JAR的数据
        new NestedLauncher().nestedRun(nestedJar);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        // 加载class对象
        Class<?> clazz = classLoader.loadClass("com.lizhengpeng.TestService");
        Object instance = clazz.newInstance();

        Method sayHello = clazz.getDeclaredMethod("sayHello");
        sayHello.invoke(instance);

        // 读取classPath下的文件
        InputStream stream = classLoader.getResourceAsStream("undersea.properties");
        byte[] bytes = IoUtil.readBytes(stream);
        System.out.println("输出内容 => \r\n" + new String(bytes, StandardCharsets.UTF_8));

    }
}
