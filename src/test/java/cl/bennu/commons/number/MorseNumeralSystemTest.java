package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MorseNumeralSystemTest extends AbstractNumeralSystemTest {

    private final MorseNumeralSystem system = new MorseNumeralSystem();

    @Override
    protected SpecificNumberSystem system() {
        return system;
    }

    @Test
    void testConvertToString() {
        assertEquals("-----", system.convert(0L));
        assertEquals(".---- ..--- ...--", system.convert(123L));
        assertEquals("----. ---.. --... -.... ..... ....-", system.convert(987_654L));
    }

    @Test
    void testConvertToLong() {
        assertEquals(0L, system.convert("-----"));
        assertEquals(123L, system.convert(" .---- ..--- ...-- "));
    }

    @Test
    void testConvertInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> system.convert(".---- .-.-"));
    }

}
