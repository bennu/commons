package cl.bennu.commons.enums.base;

import cl.bennu.commons.enums.TwoFactorTypeEnum;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EnumIdResolverTest {

    @Test
    void testExtractIdFromInteger() {
        assertEquals(5, EnumIdResolver.extractId(5));
    }

    @Test
    void testExtractIdFromMap() {
        assertEquals(3, EnumIdResolver.extractId(Map.of("id", 3, "name", "Daily")));
    }

    @Test
    void testExtractIdInvalid() {
        assertNull(EnumIdResolver.extractId(null));
        assertNull(EnumIdResolver.extractId("1"));
        assertNull(EnumIdResolver.extractId(1L));
        assertNull(EnumIdResolver.extractId(Map.of("id", "1")));
        assertNull(EnumIdResolver.extractId(Map.of("name", "Daily")));
    }

    @Test
    void testFromId() {
        assertEquals(TwoFactorTypeEnum.HOURLY,
                EnumIdResolver.fromId(TwoFactorTypeEnum.values(), 2, TwoFactorTypeEnum::getId));
    }

    @Test
    void testFromIdNotFound() {
        assertNull(EnumIdResolver.fromId(TwoFactorTypeEnum.values(), 99, TwoFactorTypeEnum::getId));
        assertNull(EnumIdResolver.fromId(TwoFactorTypeEnum.values(), null, TwoFactorTypeEnum::getId));
    }

}
