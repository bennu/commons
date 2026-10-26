package cl.bennu.commons.enums.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseEnumTest {

    enum DefaultEnum implements BaseEnum {
        FIRST(1, "First");

        private final Integer id;
        private final String name;

        DefaultEnum(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    enum NoFieldsEnum implements BaseEnum {
        ONLY
    }

    @Test
    void testDefaultGetters() {
        assertEquals(1, DefaultEnum.FIRST.getId());
        assertEquals("First", DefaultEnum.FIRST.getName());
    }

    @Test
    void testDefaultGettersWithoutFields() {
        assertThrows(RuntimeException.class, NoFieldsEnum.ONLY::getId);
        assertThrows(RuntimeException.class, NoFieldsEnum.ONLY::getName);
    }

}
