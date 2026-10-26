package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AegeanNumeralSystemTest extends AbstractNumeralSystemTest {

    private final AegeanNumeralSystem system = new AegeanNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Test
    void testConvertToString() {
        assertEquals("|", system.convert(1L));
        assertEquals("*@@999nnnn|||||", system.convert(12_345L));
        assertEquals("**", system.convert(20_000L));
    }

    @Test
    void testConvertOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(0L));
        assertThrows(IllegalArgumentException.class, () -> system.convert(-1L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(12_345L, system.convert("*@@999nnnn|||||"));
    }

    @Test
    void testConvertInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> system.convert("#"));
    }

}
