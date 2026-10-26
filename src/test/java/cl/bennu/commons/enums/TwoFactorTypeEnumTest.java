package cl.bennu.commons.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoFactorTypeEnumTest {

    @Test
    void testBaseEnum() {
        BaseEnumAssertions.assertBaseEnum(TwoFactorTypeEnum.values(), TwoFactorTypeEnum::valueOf, TwoFactorTypeEnum.class);
    }

    @Test
    void testValues() {
        assertEquals(3, TwoFactorTypeEnum.values().length);
        assertValue(TwoFactorTypeEnum.MINUTELY, 1, "Minutely");
        assertValue(TwoFactorTypeEnum.HOURLY, 2, "Hourly");
        assertValue(TwoFactorTypeEnum.DAILY, 3, "Daily");
    }

    private static void assertValue(TwoFactorTypeEnum value, int id, String name) {
        assertEquals(id, value.getId());
        assertEquals(name, value.getName());
    }

}
