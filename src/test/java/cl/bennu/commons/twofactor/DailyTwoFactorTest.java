package cl.bennu.commons.twofactor;

import cl.bennu.commons.enums.TwoFactorTypeEnum;
import cl.bennu.commons.twofactor.iface.TwoFactor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTwoFactorTest {

    @Test
    void testGenerateDefaultLength() {
        TwoFactor dailyTwoFactor = new DailyTwoFactor();
        String password = dailyTwoFactor.generate();
        assertNotNull(password);
        assertEquals(4, password.length());
    }

    @Test
    void testGenerateCustomLength() {
        TwoFactor dailyTwoFactor = new DailyTwoFactor();
        String password = dailyTwoFactor.generate(6);
        assertNotNull(password);
        assertEquals(6, password.length());

        password = dailyTwoFactor.generate(8);
        assertNotNull(password);
        assertEquals(8, password.length());
    }

    @Test
    void testGenerateInvalidLength() {
        TwoFactor dailyTwoFactor = new DailyTwoFactor();
        assertThrows(IllegalArgumentException.class, () -> dailyTwoFactor.generate(3));
        assertThrows(IllegalArgumentException.class, () -> dailyTwoFactor.generate(9));
    }

    @Test
    void testGenerateNullLength() {
        TwoFactor dailyTwoFactor = new DailyTwoFactor();
        String password = dailyTwoFactor.generate(null);
        assertNotNull(password);
        assertEquals(4, password.length());
    }
}