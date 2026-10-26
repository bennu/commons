package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MayanNumeralSystemTest extends AbstractNumeralSystemTest {

    private final MayanNumeralSystem system = new MayanNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Test
    void testConvertToString() {
        assertEquals("0", system.convert(0L));
        assertEquals(".", system.convert(1L));
        assertEquals("-..", system.convert(7L));
        assertEquals("---....", system.convert(19L));
        assertEquals(". 0", system.convert(20L));
        assertEquals(". -", system.convert(25L));
        assertEquals(". 0 0", system.convert(400L));
    }

    @Test
    void testConvertNegative() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(-1L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(0L, system.convert("0"));
        assertEquals(7L, system.convert("-.."));
        assertEquals(19L, system.convert(" ---.... "));
        assertEquals(25L, system.convert(". -"));
        assertEquals(400L, system.convert(". 0 0"));
    }

    @Test
    void testRoundTripMultipleLevels() {
        assertEquals(20L, system.convert(system.convert(20L)));
        assertEquals(25L, system.convert(system.convert(25L)));
        assertEquals(400L, system.convert(system.convert(400L)));
    }

}
