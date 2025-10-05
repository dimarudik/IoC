package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

    private final Map<Class<?>, Object> container = new HashMap<>();

    public synchronized void register(Class<?> type) {
        Object mainBean = create(type);
        container.put(type, mainBean);

        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object bean = container.get(field.getType());
                if (bean == null) {
                    Object tempBean = create(field.getType());
                    container.put(field.getType(), tempBean);
                }
                bean = container.get(field.getType());

                field.setAccessible(true);
                try {
                    field.set(mainBean, bean);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized <T> T getBean(Class<T> type) {
        Object bean = container.get(type);
        if (bean == null) throw new NullPointerException();
        return (T)bean;
    }

    private Object create(Class<?> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
