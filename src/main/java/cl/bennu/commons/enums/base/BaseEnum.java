package cl.bennu.commons.enums.base;

import java.lang.reflect.Field;

public interface BaseEnum {

    String DEFAULT_VALUE_ID = "id";
    String DEFAULT_LABEL_NAME = "name";

    default Integer getId() {
        try {
            Field field = this.getClass().getDeclaredField(DEFAULT_VALUE_ID);
            field.setAccessible(true);
            return Integer.parseInt(field.get(this).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default String getName() {
        try {
            Field field = this.getClass().getDeclaredField(DEFAULT_LABEL_NAME);
            field.setAccessible(true);
            return field.get(this).toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
