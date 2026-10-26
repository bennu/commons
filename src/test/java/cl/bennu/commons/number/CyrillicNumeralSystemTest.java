package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CyrillicNumeralSystemTest extends AbstractNumeralSystemTest {

    private final CyrillicNumeralSystem system = new CyrillicNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Test
    void testConvertToString() {
        assertEquals("а", system.convert(1L));
        assertEquals("ів", system.convert(12L));
        assertEquals("цчѳ", system.convert(999L));
    }

    @Test
    void testConvertOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(0L));
        assertThrows(IllegalArgumentException.class, () -> system.convert(1000L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(999L, system.convert("цчѳ"));
        assertEquals(12L, system.convert("ів"));
    }

    @Test
    void testConvertInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> system.convert("аz"));
    }

}
