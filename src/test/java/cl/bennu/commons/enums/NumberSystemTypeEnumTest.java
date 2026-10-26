package cl.bennu.commons.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberSystemTypeEnumTest {

    @Test
    void testBaseEnum() {
        BaseEnumAssertions.assertBaseEnum(NumberSystemTypeEnum.values(), NumberSystemTypeEnum::valueOf, NumberSystemTypeEnum.class);
    }

    @Test
    void testValues() {
        assertEquals(10, NumberSystemTypeEnum.values().length);
        assertValue(NumberSystemTypeEnum.POSITIONAL, 1, "Positional");
        assertValue(NumberSystemTypeEnum.ADDITIVE, 2, "Additive");
        assertValue(NumberSystemTypeEnum.MULTIPLICATIVE, 3, "Multiplicative");
        assertValue(NumberSystemTypeEnum.HYBRID, 4, "Hybrid");
        assertValue(NumberSystemTypeEnum.UNARY, 5, "Unary");
        assertValue(NumberSystemTypeEnum.ALPHABETICAL, 6, "Alphabetical");
        assertValue(NumberSystemTypeEnum.LOGOGRAPHIC, 7, "Logographic");
        assertValue(NumberSystemTypeEnum.NOT_POSITIONAL, 8, "Not positional");
        assertValue(NumberSystemTypeEnum.CUNEIFORM, 9, "Cuneiform");
        assertValue(NumberSystemTypeEnum.NUMERICAL_SYLLABIC, 10, "Numerical syllabic");
    }

    private static void assertValue(NumberSystemTypeEnum value, int id, String name) {
        assertEquals(id, value.getId());
        assertEquals(name, value.getName());
    }

}
