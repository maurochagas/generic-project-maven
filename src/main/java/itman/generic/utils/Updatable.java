package itman.generic.utils;

import java.lang.reflect.Field;

public class Updatable {
    public static <T> void updateProperties(T target, T source) {
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals("id")) {
                field.setAccessible(true);
                try {
                    field.set(target, field.get(source));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("The field could not be updated: " + field.getName(), e);
                }
            }
        }
    }
}
