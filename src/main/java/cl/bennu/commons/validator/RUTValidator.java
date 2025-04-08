package cl.bennu.commons.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class RUTValidator {

    public static boolean validate(long rut, String verificationDigit) {
        if (StringUtils.isBlank(verificationDigit) || rut == 0) return false;

        String rutStr = String.valueOf(rut);
        return verificationDigit.equalsIgnoreCase(calculateVerificationDigit(rutStr));
    }

    public static boolean validate(String rut) {
        if (StringUtils.isBlank(rut)) return false;

        String regex = "^[0-9]{7,8}[0-9Kk]$";
        return Pattern.matches(regex, rut);
    }

    public static boolean validateWithFormat(String rut) {
        if (StringUtils.isBlank(rut)) return false;

        String regex = "^[0-9]{1,2}\\.[0-9]{3}\\.[0-9]{3}-[0-9Kk]$";
        return Pattern.matches(regex, rut);
    }


    public static boolean validateVerificationDigit(String verificationDigit) {
        if (StringUtils.isBlank(verificationDigit)) return false;

        return verificationDigit.matches("[0-9Kk]");
    }

    public static String[] split(String rut) {
        if (rut == null || rut.length() < 2) {
            return new String[]{StringUtils.EMPTY, StringUtils.EMPTY};
        }

        rut = rut.replace(".", StringUtils.EMPTY).replace("-", StringUtils.EMPTY);

        String rutNumber = rut.substring(0, rut.length() - 1);
        String verificationDigit = rut.substring(rut.length() - 1);

        return new String[]{rutNumber, verificationDigit};
    }

    public static String calculateVerificationDigit(String rut) {
        int sum = 0;
        int multiplier = 2;

        for (int i = rut.length() - 1; i >= 0; i--) {
            sum += Character.getNumericValue(rut.charAt(i)) * multiplier;
            multiplier = multiplier == 7 ? 2 : multiplier + 1;
        }

        int mod = 11 - (sum % 11);
        if (mod == 11) {
            return "0";
        } else if (mod == 10) {
            return "K";
        } else {
            return String.valueOf(mod);
        }
    }

}
