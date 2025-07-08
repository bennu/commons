package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoFactorTest {

    @Test
    void testGenerateMinutelyPasswordDefaultLength() {
        String password = TwoFactor.generateMinutelyPassword();
        assertNotNull(password);
        assertEquals(4, password.length());
    }

    @Test
    void testGenerateMinutelyPasswordCustomLength() {
        String password = TwoFactor.generateMinutelyPassword(6);
        assertNotNull(password);
        assertEquals(6, password.length());

        password = TwoFactor.generateMinutelyPassword(8);
        assertNotNull(password);
        assertEquals(8, password.length());
    }

    @Test
    void testGenerateMinutelyPasswordInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> TwoFactor.generateMinutelyPassword(3));
        assertThrows(IllegalArgumentException.class, () -> TwoFactor.generateMinutelyPassword(9));
    }

    @Test
    void testGenerateMinutelyPasswordNullLength() {
        String password = TwoFactor.generateMinutelyPassword(null);
        assertNotNull(password);
        assertEquals(4, password.length());
    }
}