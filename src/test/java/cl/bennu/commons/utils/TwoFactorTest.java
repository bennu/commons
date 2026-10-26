package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("deprecation")
public class TwoFactorTest {

    @Test
    void testGenerateMinutelyPasswordDefaultLength() {
        String password = TwoFactor.generateMinutelyPassword();
        assertEquals(4, password.length());
        assertTrue(password.matches("\\d+"));
    }

    @Test
    void testGenerateMinutelyPasswordValidLengths() {
        for (int length = 4; length <= 8; length++) {
            String password = TwoFactor.generateMinutelyPassword(length);
            assertEquals(length, password.length());
            assertTrue(password.matches("\\d+"));
        }
    }

    @Test
    void testGenerateMinutelyPasswordInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> TwoFactor.generateMinutelyPassword(3));
        assertThrows(IllegalArgumentException.class, () -> TwoFactor.generateMinutelyPassword(9));
    }

}
