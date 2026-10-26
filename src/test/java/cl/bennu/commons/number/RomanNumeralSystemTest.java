package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralSystemTest extends AbstractNumeralSystemTest {

    private final RomanNumeralSystem system = new RomanNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Override
    protected long roundTripMax() {
        return 3999;
    }

    @Test
    void testConvertToString() {
        assertEquals("I", system.convert(1L));
        assertEquals("IV", system.convert(4L));
        assertEquals("XLIX", system.convert(49L));
        assertEquals("MMXXIV", system.convert(2024L));
        assertEquals("MMMCMXCIX", system.convert(3999L));
    }

    @Test
    void testConvertOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(0L));
        assertThrows(IllegalArgumentException.class, () -> system.convert(-1L));
        assertThrows(IllegalArgumentException.class, () -> system.convert(4000L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(2024L, system.convert("MMXXIV"));
        assertEquals(2024L, system.convert("mmxxiv"));
        assertEquals(0L, system.convert(""));
    }

    @Test
    void testConvertInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> system.convert("XIZ"));
    }

}
