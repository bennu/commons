package cl.bennu.commons.enums;

import cl.bennu.commons.enums.base.EnumLookup;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static cl.bennu.commons.enums.BaseEnumAssertions.OBJECT_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyEnumTest {

    @Test
    void testBaseEnum() {
        BaseEnumAssertions.assertBaseEnum(CurrencyEnum.values(), CurrencyEnum::valueOf, CurrencyEnum.class);
    }

    @Test
    void testCount() {
        assertEquals(184, CurrencyEnum.values().length);
    }

    @Test
    void testCodesAndSymbols() {
        for (CurrencyEnum currency : CurrencyEnum.values()) {
            assertTrue(currency.getCode().matches("[A-Z]{3}"), currency.name());
            assertNotNull(currency.getSymbol(), currency.name());
            assertFalse(currency.getSymbol().isBlank(), currency.name());
        }
    }

    @Test
    void testChileanPeso() {
        CurrencyEnum peso = CurrencyEnum.CHILEAN_PESO;
        assertEquals(21, peso.getId());
        assertEquals("CLP", peso.getCode());
        assertEquals("Peso chileno", peso.getName());
        assertEquals("$", peso.getSymbol());
    }

    @Test
    void testLookupByCode() {
        assertEquals(CurrencyEnum.CHILEAN_PESO, EnumLookup.find(CurrencyEnum.values(), "CLP", CurrencyEnum::getCode));
        assertNull(EnumLookup.find(CurrencyEnum.values(), "XXX", CurrencyEnum::getCode));
    }

    @Test
    void testLookupBySharedCodeReturnsFirstDeclared() {
        // EUR lo comparten EURO y KOSOVO_EURO
        assertEquals(CurrencyEnum.EURO, EnumLookup.find(CurrencyEnum.values(), "EUR", CurrencyEnum::getCode));
    }

    @Test
    void testSerializeIncludesCodeAndSymbol() {
        Map<?, ?> map = OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(CurrencyEnum.EURO), Map.class);
        assertEquals("EUR", map.get("code"));
        assertEquals("€", map.get("symbol"));
    }

}
