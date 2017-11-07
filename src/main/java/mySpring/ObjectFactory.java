package mySpring;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private ObjectFieldsConfiguratorConfig fieldsConfiguratorConfig = new ObjectFieldsConfiguratorConfig();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImpl(type);
        }
        T o = type.newInstance();

        Field[] fields = type.getDeclaredFields();

        // I just implemented configuration for fields, but in the similar way we can do it for class annotations

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();

            for (Annotation annotation : annotations) {
                ObjectFieldConfigurator configurator = fieldsConfiguratorConfig.getImpl(annotation.annotationType());

                if (configurator != null) {
                    configurator.configure(field, o, annotation);
                }
            }
        }

        return o;
    }
}
