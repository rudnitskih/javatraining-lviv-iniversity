package mySpring.objectFieldsConfigurators;

import lombok.SneakyThrows;
import mySpring.ObjectFieldConfigurator;
import mySpring.annotations.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntConfigurator implements ObjectFieldConfigurator<InjectRandomInt> {
    private Random random = new Random();

    @Override
    @SneakyThrows
    public void configure(Field field, Object o, InjectRandomInt annotation) {
        int min = annotation.min();
        int max = annotation.max();
        int randomIntValue = random.nextInt(max - min) + min;
        field.setAccessible(true);
        field.set(o, randomIntValue);
    }
}
