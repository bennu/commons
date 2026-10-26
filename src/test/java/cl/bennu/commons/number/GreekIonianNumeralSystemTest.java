package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GreekIonianNumeralSystemTest extends AbstractNumeralSystemTest {

    private final GreekIonianNumeralSystem system = new GreekIonianNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Test
    void testConvertToString() {
        assertEquals("α", system.convert(1L));
        assertEquals("ρκγ", system.convert(123L));
        assertEquals("ϡϟθ", system.convert(999L));
    }

    @Test
    void testConvertOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(0L));
        assertThrows(IllegalArgumentException.class, () -> system.convert(1000L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(123L, system.convert("ρκγ"));
        assertEquals(123L, system.convert("ΡΚΓ"));
    }

    @Test
    void testConvertInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> system.convert("αz"));
    }

}
