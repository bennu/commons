package cl.bennu.commons.enums;

import cl.bennu.commons.number.RomanNumeralSystem;
import cl.bennu.commons.utils.NumberUtils;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static cl.bennu.commons.enums.BaseEnumAssertions.OBJECT_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

public class NumericBaseEnumTest {

    @Test
    void testBaseEnum() {
        BaseEnumAssertions.assertBaseEnum(NumericBaseEnum.values(), NumericBaseEnum::valueOf, NumericBaseEnum.class);
    }

    @Test
    void testCount() {
        assertEquals(46, NumericBaseEnum.values().length);
    }

    @Test
    void testBaseOrSpecificSystem() {
        for (NumericBaseEnum numericBase : NumericBaseEnum.values()) {
            assertNotNull(numericBase.getNumberSystemTypeEnum(), numericBase.name());
            assertTrue(numericBase.getBase() != null ^ numericBase.getSpecificNumberSystem() != null,
                    "Debe tener base o sistema específico, no ambos: " + numericBase.name());
        }
    }

    @Test
    void testPositionalBases() {
        Set<Integer> bases = new HashSet<>();
        for (NumericBaseEnum numericBase : NumericBaseEnum.values()) {
            if (numericBase.getBase() == null) continue;

            assertEquals(NumberSystemTypeEnum.POSITIONAL, numericBase.getNumberSystemTypeEnum(), numericBase.name());
            assertTrue(numericBase.getBase() >= Character.MIN_RADIX && numericBase.getBase() <= Character.MAX_RADIX,
                    numericBase.name());
            assertTrue(bases.add(numericBase.getBase()), "Base duplicada " + numericBase.getBase());
        }
        for (int radix = Character.MIN_RADIX; radix <= Character.MAX_RADIX; radix++) {
            assertTrue(bases.contains(radix), "Falta la base " + radix);
        }
    }

    @Test
    void testKnownValues() {
        assertEquals(2, NumericBaseEnum.BINARY.getBase());
        assertEquals(8, NumericBaseEnum.OCTAL.getBase());
        assertEquals(10, NumericBaseEnum.DECIMAL.getBase());
        assertEquals(16, NumericBaseEnum.HEXADECIMAL.getBase());
        assertEquals(36, NumericBaseEnum.BASE_36.getBase());
        assertNull(NumericBaseEnum.ROMAN.getBase());
        assertInstanceOf(RomanNumeralSystem.class, NumericBaseEnum.ROMAN.getSpecificNumberSystem());
        assertEquals(NumberSystemTypeEnum.ADDITIVE, NumericBaseEnum.ROMAN.getNumberSystemTypeEnum());
    }

    @Test
    void testEveryBaseConvertsRoundTrip() {
        for (NumericBaseEnum numericBase : NumericBaseEnum.values()) {
            for (long number = 1; number <= 499; number++) {
                String converted = NumberUtils.convert(number, numericBase);
                assertEquals(number, NumberUtils.convert(converted, numericBase),
                        numericBase.name() + " falló con " + number + " -> " + converted);
            }
        }
    }

    @Test
    void testSerializeIncludesBaseAndType() {
        Map<?, ?> map = OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(NumericBaseEnum.HEXADECIMAL), Map.class);
        assertEquals(16, map.get("base"));
        assertEquals(1, ((Map<?, ?>) map.get("numberSystemTypeEnum")).get("id"));
    }

}
