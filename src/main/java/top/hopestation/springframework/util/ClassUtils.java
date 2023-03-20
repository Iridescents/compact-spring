package top.hopestation.springframework.util;

public class ClassUtils {
    public static ClassLoader getClassLoader() {
        // 是否需要加try catch
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
