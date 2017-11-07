package mySpring;

import java.lang.reflect.Field;

public interface ObjectFieldConfigurator<T> {
    void configure(Field field, Object o, T annotation);
}
