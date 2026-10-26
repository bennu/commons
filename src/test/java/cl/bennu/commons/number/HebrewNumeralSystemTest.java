package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HebrewNumeralSystemTest extends AbstractNumeralSystemTest {

    private final HebrewNumeralSystem system = new HebrewNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Override
    protected long roundTripMax() {
        return 499;
    }

    @Test
    void testConvertToString() {
        assertEquals("א", system.convert(1L));
        assertEquals("קכג", system.convert(123L));
        assertEquals("תצט", system.convert(499L));
    }

    @Test
    void testConvertOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(0L));
        assertThrows(IllegalArgumentException.class, () -> system.convert(500L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(123L, system.convert("קכג"));
        assertEquals(499L, system.convert("תצט"));
    }

    @Test
    void testConvertInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> system.convert("אz"));
    }

}
