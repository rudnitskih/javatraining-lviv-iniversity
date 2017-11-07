package mySpring.objectFieldsConfigurators;

import lombok.SneakyThrows;
import mySpring.ObjectFieldConfigurator;
import mySpring.annotations.MultiplyByValue;

import java.lang.reflect.Field;

public class MultiplyByValueConfigurator implements ObjectFieldConfigurator<MultiplyByValue> {
    @Override
    @SneakyThrows
    public void configure(Field field, Object o, MultiplyByValue annotation) {
        int multiplier = annotation.value();

        if (field.getType().isAssignableFrom(int.class) /*And other checks like Integer, Float...*/) {
            field.setAccessible(true);
            field.set(o, (Integer) field.get(o) * multiplier);
        } else {
            throw new IllegalStateException("MultiplyByValue annotation applicable only for numeric fields");
        }
    }
}
