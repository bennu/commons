package cl.bennu.commons.enums.base;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public final class EnumLookup {
    private EnumLookup() {
    }

    public static <E extends Enum<E>, K> E find(E[] values, K key, Function<E, K> keyExtractor) {
        if (key == null) {
            return null;
        }
        return Arrays.stream(values)
                .filter(e -> Objects.equals(keyExtractor.apply(e), key))
                .findFirst()
                .orElse(null);
    }

    public static <E extends Enum<E>, K> E findOrThrow(E[] values, K key, Function<E, K> keyExtractor) {
        E result = find(values, key, keyExtractor);
        if (result == null) {
            throw new IllegalArgumentException(
                    values.getClass().getComponentType().getSimpleName() + " not supported: " + key);
        }
        return result;
    }
}
