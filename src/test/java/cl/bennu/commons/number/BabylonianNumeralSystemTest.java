package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BabylonianNumeralSystemTest extends AbstractNumeralSystemTest {

    private final BabylonianNumeralSystem system = new BabylonianNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Override
    protected long roundTripMax() {
        return 7200;
    }

    @Test
    void testConvertToString() {
        assertEquals("0", system.convert(0L));
        assertEquals("|", system.convert(1L));
        assertEquals("^^^^^|||||||||", system.convert(59L));
        assertEquals("| |", system.convert(61L));
        assertEquals("| | |", system.convert(3661L));
        assertEquals("| 0", system.convert(60L));
        assertEquals("| 0 |", system.convert(3601L));
    }

    @Test
    void testConvertNegative() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(-1L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(0L, system.convert("0"));
        assertEquals(59L, system.convert("^^^^^|||||||||"));
        assertEquals(61L, system.convert("| |"));
        assertEquals(3661L, system.convert("| | |"));
        assertEquals(754L, system.convert("^|| ^^^||||"));
    }

    @Test
    void testZeroDigits() {
        assertEquals(60L, system.convert(system.convert(60L)));
        assertEquals(3601L, system.convert(system.convert(3601L)));
    }

}
