package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractNumeralSystemTest {

    protected abstract SpecificNumberSystem system();

    protected long roundTripMax() {
        return 999;
    }

    @Test
    void testConvertNull() {
        assertThrows(IllegalArgumentException.class, () -> system().convert((Long) null));
        assertThrows(IllegalArgumentException.class, () -> system().convert((Integer) null));
    }

    @Test
    void testConvertOverloadsAreConsistent() {
        SpecificNumberSystem system = system();
        String expected = system.convert(42L);
        assertEquals(expected, system.convert(Long.valueOf(42)));
        assertEquals(expected, system.convert(42));
        assertEquals(expected, system.convert(Integer.valueOf(42)));
    }

    @Test
    void testRoundTrip() {
        SpecificNumberSystem system = system();
        for (long i = 1; i <= roundTripMax(); i++) {
            assertEquals(i, system.convert(system.convert(i)), "Round trip failed for " + i);
        }
    }

}
