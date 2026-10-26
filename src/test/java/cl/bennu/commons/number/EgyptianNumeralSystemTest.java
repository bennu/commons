package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EgyptianNumeralSystemTest extends AbstractNumeralSystemTest {

    private final EgyptianNumeralSystem system = new EgyptianNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Test
    void testConvertToString() {
        assertEquals("|", system.convert(1L));
        assertEquals("n|||", system.convert(13L));
        assertEquals("#~~***@@@@99999nnnnnn|||||||", system.convert(1_234_567L));
    }

    @Test
    void testConvertOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(0L));
        assertThrows(IllegalArgumentException.class, () -> system.convert(-1L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(1_234_567L, system.convert("#~~***@@@@99999nnnnnn|||||||"));
        assertEquals(13L, system.convert("|||n"));
    }

    @Test
    void testConvertInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> system.convert("n?"));
    }

}
