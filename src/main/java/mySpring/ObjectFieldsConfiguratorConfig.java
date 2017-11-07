package mySpring;

import mySpring.annotations.InjectRandomInt;
import mySpring.annotations.MultiplyByValue;
import mySpring.objectFieldsConfigurators.InjectRandomIntConfigurator;
import mySpring.objectFieldsConfigurators.MultiplyByValueConfigurator;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ObjectFieldsConfiguratorConfig {
    private Map<Class<? extends Annotation>, ObjectFieldConfigurator<? extends Annotation>> map = new HashMap<>();

    public ObjectFieldsConfiguratorConfig() {
        map.put(InjectRandomInt.class, new InjectRandomIntConfigurator());
        map.put(MultiplyByValue.class, new MultiplyByValueConfigurator());
    }

    public ObjectFieldConfigurator getImpl(Class<? extends Annotation> annotation) {
        return map.get(annotation);
    }
}
