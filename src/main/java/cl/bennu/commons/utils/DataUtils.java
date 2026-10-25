package cl.bennu.commons.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class DataUtils {

    public static boolean isEmpty(Object result) {
        if (result == null) {
            return true;
        }
        if (result instanceof Collection<?> collection) {
            return collection.isEmpty();
        }
        if (result instanceof Map<?, ?> map) {
            return map.isEmpty();
        }
        if (result instanceof String text) {
            return StringUtils.isBlank(text);
        }
        if (result instanceof CharSequence text) {
            return text.isEmpty();
        }
        if (result.getClass().isArray()) {
            return Array.getLength(result) == 0;
        }

        return false;
    }

}
