package cl.bennu.commons.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RUTValidatorTest {

    @Test
    void testValidateWithLongAndVerificationDigit() {
        assertTrue(RUTValidator.validate(16431706, "4"));
        assertTrue(RUTValidator.validate(76092963, "8"));

        assertFalse(RUTValidator.validate(0L, "K"));
        assertFalse(RUTValidator.validate(12345678L, ""));
        assertFalse(RUTValidator.validate(12345678L, "X"));
        assertFalse(RUTValidator.validate(12345678L, null));
    }

    @Test
    void testValidateWithString() {
        assertTrue(RUTValidator.validate("164317064"));
        assertTrue(RUTValidator.validate("760929638"));

        assertFalse(RUTValidator.validate("12345678X"));
        assertFalse(RUTValidator.validate("1234"));
        assertFalse(RUTValidator.validate(""));
        assertFalse(RUTValidator.validate(null));
    }

    @Test
    void testValidateWithFormat() {
        assertTrue(RUTValidator.validateWithFormat("16.431.706-4"));
        assertTrue(RUTValidator.validateWithFormat("76.092.963-8"));

        assertFalse(RUTValidator.validateWithFormat("16431.706-4"));
        assertFalse(RUTValidator.validateWithFormat("16431706-4"));
        assertFalse(RUTValidator.validateWithFormat("164.31.706-4"));
        assertFalse(RUTValidator.validateWithFormat("16.4317.06-4"));
        assertFalse(RUTValidator.validateWithFormat("16.431706-4"));

        assertFalse(RUTValidator.validateWithFormat("12345678K"));
        assertFalse(RUTValidator.validateWithFormat("12.345.678-X"));
        assertFalse(RUTValidator.validateWithFormat(""));
        assertFalse(RUTValidator.validateWithFormat(null));
    }

    @Test
    void testValidateVerificationDigit() {
        assertTrue(RUTValidator.validateVerificationDigit("K"));
        assertTrue(RUTValidator.validateVerificationDigit("0"));

        assertFalse(RUTValidator.validateVerificationDigit("X"));
        assertFalse(RUTValidator.validateVerificationDigit(""));
        assertFalse(RUTValidator.validateVerificationDigit(null));
    }

    @Test
    void testSplit() {
        String[] result = RUTValidator.split("16431706-4");
        assertEquals("16431706", result[0]);
        assertEquals("4", result[1]);

        result = RUTValidator.split("76.092.963-8");
        assertEquals("76092963", result[0]);
        assertEquals("8", result[1]);
    }

    @Test
    void testCalculateVerificationDigit() {
        assertEquals("4", RUTValidator.calculateVerificationDigit("16431706"));
        assertEquals("8", RUTValidator.calculateVerificationDigit("76092963"));
    }

}