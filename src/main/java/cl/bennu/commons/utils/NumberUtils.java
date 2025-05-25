package cl.bennu.commons.utils;

import cl.bennu.commons.enums.NumericBaseEnum;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;

public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

    public static boolean isNullOrZero(Number number) {
        if (number == null) return true;

        if (number instanceof Integer) {
            return (Integer) number == 0;
        } else if (number instanceof Long) {
            return (Long) number == 0L;
        } else if (number instanceof Double) {
            return (Double) number == 0.0;
        } else if (number instanceof Float) {
            return (Float) number == 0.0F;
        } else if (number instanceof Short) {
            return (Short) number == 0;
        } else if (number instanceof Byte) {
            return (Byte) number == 0;
        }

        return true;
    }

    public static boolean isNotNullOrZero(Number number) {
        return !isNullOrZero(number);
    }

    public static long getValue(Long value) {
        if (value == null) return 0L;
        return value;
    }

    public static double getValue(Double value) {
        if (value == null) return 0.0D;
        return value;
    }

    public static float getValue(Float value) {
        if (value == null) return 0.0F;
        return value;
    }

    public static int getValue(Integer value) {
        if (value == null) return 0;
        return value;
    }

    public static short getValue(Short value) {
        if (value == null) return 0;
        return value;
    }

    public static byte getValue(Byte value) {
        if (value == null) return 0;
        return value;
    }

    public static String format(Double value) {
        return format(value, 0);
    }

    public static String format(Double value, int places) {
        String pattern = "###,###." + StringUtils.leftPad(StringUtils.EMPTY, places, "0");
        if (places == 0) pattern = "###,###";

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setCurrency(Currency.getInstance("CLP"));
        decimalFormatSymbols.setGroupingSeparator('.');
        decimalFormatSymbols.setDecimalSeparator(',');
        NumberFormat numberFormat = new DecimalFormat(pattern, decimalFormatSymbols);
        String str = numberFormat.format(getValue(value));
        if (str.startsWith(",")) str = "0" + str;

        return str;
    }

    public static String convert(long number, NumericBaseEnum numericBaseEnum) {
        if (numericBaseEnum == null) {
            throw new IllegalArgumentException("NumericBaseEnum cannot be null");
        }

        if (numericBaseEnum.getSpecificNumberSystem() == null) {
            return Long.toString(number, numericBaseEnum.getBase()).toUpperCase();
        } else {
            return numericBaseEnum.getSpecificNumberSystem().convert(number);
        }
    }

    public static String convert(Integer number, NumericBaseEnum numericBaseEnum) {
        if (number == null) {
            throw new IllegalArgumentException("Number cannot be null");
        }

        return convert(number.longValue(), numericBaseEnum);
    }

    public static String convert(Long number, NumericBaseEnum numericBaseEnum) {
        if (number == null) {
            throw new IllegalArgumentException("Number cannot be null");
        }

        return convert(number.longValue(), numericBaseEnum);
    }

    public static long convert(String value, NumericBaseEnum numericBaseEnum) {
        if (numericBaseEnum == null) {
            throw new IllegalArgumentException("NumericBaseEnum cannot be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        if (numericBaseEnum.getSpecificNumberSystem() == null) {
            return Long.parseLong(value, numericBaseEnum.getBase());
        } else {
            return numericBaseEnum.getSpecificNumberSystem().convert(value);
        }

    }

}
