package tdd;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class TestRunner {
    @SneakyThrows
    public void runAllTestMethods(Object o) {
        // find all methods starts with test
        Class<?> clazz = o.getClass();


        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("test")) {
                method.invoke(o);
            }
        }

    }
}
