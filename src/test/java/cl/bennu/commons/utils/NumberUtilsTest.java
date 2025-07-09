package cl.bennu.commons.utils;

import cl.bennu.commons.enums.NumericBaseEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {


    @Test
    void testIsNullOrZero() {
        assertTrue(NumberUtils.isNullOrZero(null));
        assertTrue(NumberUtils.isNullOrZero(0));
        assertTrue(NumberUtils.isNullOrZero(0L));
        assertTrue(NumberUtils.isNullOrZero(0.0));
        assertTrue(NumberUtils.isNullOrZero(0.0F));

        assertFalse(NumberUtils.isNullOrZero(1));
        assertFalse(NumberUtils.isNullOrZero(1L));
        assertFalse(NumberUtils.isNullOrZero(1.0));
        assertFalse(NumberUtils.isNullOrZero(1.0F));
    }

    @Test
    void testIsNotNullOrZero() {
        assertFalse(NumberUtils.isNotNullOrZero(null));
        assertFalse(NumberUtils.isNotNullOrZero(0));
        assertFalse(NumberUtils.isNotNullOrZero(0L));
        assertFalse(NumberUtils.isNotNullOrZero(0.0));
        assertFalse(NumberUtils.isNotNullOrZero(0.0F));

        assertTrue(NumberUtils.isNotNullOrZero(1));
        assertTrue(NumberUtils.isNotNullOrZero(1L));
        assertTrue(NumberUtils.isNotNullOrZero(1.0));
        assertTrue(NumberUtils.isNotNullOrZero(1.0F));
    }

    @Test
    void testGetValue() {
        assertEquals(0L, NumberUtils.getValue((Long) null));
        assertEquals(0.0, NumberUtils.getValue((Double) null));
        assertEquals(0.0F, NumberUtils.getValue((Float) null));
        assertEquals(0, NumberUtils.getValue((Integer) null));
        assertEquals(0, NumberUtils.getValue((Short) null));
        assertEquals(0, NumberUtils.getValue((Byte) null));

        assertEquals(10L, NumberUtils.getValue(10L));
        assertEquals(10.5, NumberUtils.getValue(10.5));
        assertEquals(10.5F, NumberUtils.getValue(10.5F));
        assertEquals(10, NumberUtils.getValue(10));
        assertEquals((short) 10, NumberUtils.getValue((short) 10));
        assertEquals((byte) 10, NumberUtils.getValue((byte) 10));
    }

    @Test
    void testFormat() {
        assertEquals("0", NumberUtils.format(null));
        assertEquals("1.000", NumberUtils.format(1000.0));
        assertEquals("1.000,50", NumberUtils.format(1000.5, 2));
    }

    @Test
    void testConvertToString() {
        assertEquals("A", NumberUtils.convert(10L, NumericBaseEnum.HEXADECIMAL));
        assertEquals("1010", NumberUtils.convert(10L, NumericBaseEnum.BINARY));
        assertEquals("12", NumberUtils.convert(10L, NumericBaseEnum.OCTAL));
        assertEquals("II", NumberUtils.convert(2L, NumericBaseEnum.ROMAN));
        assertEquals("VII", NumberUtils.convert(7L, NumericBaseEnum.ROMAN));
        assertEquals("CMXCIX", NumberUtils.convert(999L, NumericBaseEnum.ROMAN));
        assertEquals(".---- .---- ----- ....- ..---", NumberUtils.convert(11042L, NumericBaseEnum.MORSE));
    }

    @Test
    void testConvertToLong() {
        assertEquals(10L, NumberUtils.convert("A", NumericBaseEnum.HEXADECIMAL));
        assertEquals(10L, NumberUtils.convert("1010", NumericBaseEnum.BINARY));
        assertEquals(10L, NumberUtils.convert("12", NumericBaseEnum.OCTAL));
        assertEquals(999L, NumberUtils.convert("CMXCIX", NumericBaseEnum.ROMAN));
        assertEquals(11042, NumberUtils.convert(".---- .---- ----- ....- ..---", NumericBaseEnum.MORSE));
    }

    @Test
    void testConvertWithNullValues() {
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.convert((Long) null, null));
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.convert((Integer) null, null));
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.convert((String) null, null));
    }

}
