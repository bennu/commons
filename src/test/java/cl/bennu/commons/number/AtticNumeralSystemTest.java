package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtticNumeralSystemTest extends AbstractNumeralSystemTest {

    private final AtticNumeralSystem system = new AtticNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Test
    void testConvertToString() {
        assertEquals("Ι", system.convert(1L));
        assertEquals("Π", system.convert(5L));
        assertEquals("ΠΙΙΙΙ", system.convert(9L));
        assertEquals("ΧΧΔΔΙΙΙΙ", system.convert(2024L));
        assertEquals("ΜΥ", system.convert(100_000L));
        assertEquals("ΜΩ", system.convert(1_000_000L));
        assertEquals("ΜΔ", system.convert(10_010L));
    }

    @Test
    void testConvertOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(0L));
        assertThrows(IllegalArgumentException.class, () -> system.convert(-5L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(2024L, system.convert("ΧΧΔΔΙΙΙΙ"));
        assertEquals(1_000_000L, system.convert("ΜΩ"));
        assertEquals(10_010L, system.convert("ΜΔ"));
        assertEquals(100_000L, system.convert("ΜΥ"));
    }

    @Test
    void testConvertInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> system.convert("ΧA"));
    }

    @Test
    void testAmbiguousSymbols() {
        assertEquals(10_010L, system.convert(system.convert(10_010L)));
        assertEquals(1_010_010L, system.convert(system.convert(1_010_010L)));
    }

}
