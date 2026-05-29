package cl.bennu.commons.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public final class EnumIdResolver {

    private static final String ID_KEY = "id";

    private EnumIdResolver() {
        // Prevent instantiation.
    }

    public static Integer extractId(Object o) {
        if (o instanceof Integer id) {
            return id;
        }
        if (o instanceof Map<?, ?> map && map.get(ID_KEY) instanceof Integer id) {
            return id;
        }
        return null;
    }

    public static <E> E fromId(E[] values, Integer id, Function<E, Integer> idExtractor) {
        if (id == null) {
            return null;
        }
        return Arrays.stream(values)
                .filter(value -> id.equals(idExtractor.apply(value)))
                .findFirst()
                .orElse(null);
    }
}