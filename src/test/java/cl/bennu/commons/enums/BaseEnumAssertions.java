package cl.bennu.commons.enums;

import cl.bennu.commons.enums.base.BaseEnum;
import tools.jackson.databind.ObjectMapper;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Validaciones comunes a todos los enums que implementan {@link BaseEnum}.
 */
final class BaseEnumAssertions {

    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private BaseEnumAssertions() {
        // Prevent instantiation.
    }

    static <E extends Enum<E> & BaseEnum> void assertIdsAndNames(E[] values) {
        Set<Integer> ids = new HashSet<>();
        for (E value : values) {
            assertNotNull(value.getId(), value.name());
            assertTrue(value.getId() > 0, value.name());
            assertNotNull(value.getName(), value.name());
            assertFalse(value.getName().isBlank(), value.name());
            assertTrue(ids.add(value.getId()), "Id duplicado " + value.getId() + " en " + value.name());
        }
    }

    static <E extends Enum<E> & BaseEnum> void assertValueOf(E[] values, Function<Object, E> valueOf) {
        for (E value : values) {
            assertSame(value, valueOf.apply(value.getId()), value.name());
            assertSame(value, valueOf.apply(Map.of("id", value.getId())), value.name());
        }
        assertNull(valueOf.apply(null));
        assertNull(valueOf.apply(0));
        assertNull(valueOf.apply(Integer.MAX_VALUE));
        assertNull(valueOf.apply("1"));
        assertNull(valueOf.apply(1L));
        assertNull(valueOf.apply(Map.of("name", "x")));
    }

    static <E extends Enum<E> & BaseEnum> void assertJson(E[] values, Class<E> clazz) {
        for (E value : values) {
            String json = OBJECT_MAPPER.writeValueAsString(value);
            Map<?, ?> map = OBJECT_MAPPER.readValue(json, Map.class);
            assertEquals(value.getId(), map.get("id"), value.name());
            assertEquals(value.getName(), map.get("name"), value.name());

            assertSame(value, OBJECT_MAPPER.readValue(json, clazz), value.name());
            assertSame(value, OBJECT_MAPPER.readValue(String.valueOf(value.getId()), clazz), value.name());
        }
    }

    static <E extends Enum<E> & BaseEnum> void assertBaseEnum(E[] values, Function<Object, E> valueOf, Class<E> clazz) {
        assertIdsAndNames(values);
        assertValueOf(values, valueOf);
        assertJson(values, clazz);
    }

}
