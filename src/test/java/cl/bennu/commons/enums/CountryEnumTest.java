package cl.bennu.commons.enums;

import cl.bennu.commons.enums.base.EnumLookup;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static cl.bennu.commons.enums.BaseEnumAssertions.OBJECT_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

public class CountryEnumTest {

    @Test
    void testBaseEnum() {
        BaseEnumAssertions.assertBaseEnum(CountryEnum.values(), CountryEnum::valueOf, CountryEnum.class);
    }

    @Test
    void testCount() {
        assertEquals(194, CountryEnum.values().length);
    }

    @Test
    void testCodesAreUniqueIsoAlpha3() {
        Set<String> codes = new HashSet<>();
        for (CountryEnum country : CountryEnum.values()) {
            assertTrue(country.getCode().matches("[A-Z]{3}"), country.name());
            assertTrue(codes.add(country.getCode()), "Código duplicado " + country.getCode());
        }
    }

    @Test
    void testNamesAreUnique() {
        Set<String> names = new HashSet<>();
        for (CountryEnum country : CountryEnum.values()) {
            assertTrue(names.add(country.getName()), "Nombre duplicado " + country.getName());
        }
    }

    @Test
    void testIndependenceYearAndCurrency() {
        int currentYear = Year.now().getValue();
        for (CountryEnum country : CountryEnum.values()) {
            assertNotNull(country.getIndependenceYear(), country.name());
            assertTrue(country.getIndependenceYear() > 0 && country.getIndependenceYear() <= currentYear, country.name());
            assertNotNull(country.getCurrencyEnum(), country.name());
        }
    }

    @Test
    void testChile() {
        CountryEnum chile = CountryEnum.CHILE;
        assertEquals(35, chile.getId());
        assertEquals("CHL", chile.getCode());
        assertEquals("Chile", chile.getName());
        assertEquals(1818, chile.getIndependenceYear());
        assertEquals(CurrencyEnum.CHILEAN_PESO, chile.getCurrencyEnum());
    }

    @Test
    void testLookupByCode() {
        assertEquals(CountryEnum.CHILE, EnumLookup.find(CountryEnum.values(), "CHL", CountryEnum::getCode));
        assertEquals(CountryEnum.UNITED_STATES, EnumLookup.findOrThrow(CountryEnum.values(), "USA", CountryEnum::getCode));
        assertNull(EnumLookup.find(CountryEnum.values(), "XXX", CountryEnum::getCode));
    }

    @Test
    void testSerializeIncludesCurrency() {
        Map<?, ?> map = OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(CountryEnum.CHILE), Map.class);
        assertEquals("CHL", map.get("code"));
        assertEquals(1818, map.get("independenceYear"));
        Map<?, ?> currency = (Map<?, ?>) map.get("currencyEnum");
        assertEquals(21, currency.get("id"));
        assertEquals("CLP", currency.get("code"));
    }

}
