package cl.bennu.commons.enums.base;

import cl.bennu.commons.enums.CurrencyEnum;
import cl.bennu.commons.enums.QueueEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnumLookupTest {

    @Test
    void testFind() {
        assertEquals(QueueEnum.ERROR, EnumLookup.find(QueueEnum.values(), "Error", QueueEnum::getName));
        assertEquals(QueueEnum.FINALIZED, EnumLookup.find(QueueEnum.values(), 4, QueueEnum::getId));
    }

    @Test
    void testFindReturnsFirstMatch() {
        assertEquals(CurrencyEnum.SENEGAL_FRANC, EnumLookup.find(CurrencyEnum.values(), "XOF", CurrencyEnum::getCode));
    }

    @Test
    void testFindNotFound() {
        assertNull(EnumLookup.find(QueueEnum.values(), "Unknown", QueueEnum::getName));
        assertNull(EnumLookup.find(QueueEnum.values(), null, QueueEnum::getName));
    }

    @Test
    void testFindOrThrow() {
        assertEquals(QueueEnum.PENDING, EnumLookup.findOrThrow(QueueEnum.values(), 1, QueueEnum::getId));
    }

    @Test
    void testFindOrThrowNotFound() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> EnumLookup.findOrThrow(QueueEnum.values(), 99, QueueEnum::getId));
        assertEquals("QueueEnum not supported: 99", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,
                () -> EnumLookup.findOrThrow(QueueEnum.values(), null, QueueEnum::getId));
        assertEquals("QueueEnum not supported: null", e.getMessage());
    }

}
