package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

public class RomanNumeralSystem implements SpecificNumberSystem {

    private static final String[] ROMAN_NUMS = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };
    private static final int[] ROMAN_VALS = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    @Override
    public String convert(Long number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(long number) {
        if (number <= 0 || number > 3999) throw new IllegalArgumentException("Roman number must be between 1 and 3999");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROMAN_VALS.length; i++) {
            while (number >= ROMAN_VALS[i]) {
                sb.append(ROMAN_NUMS[i]);
                number -= ROMAN_VALS[i];
            }
        }
        return sb.toString();
    }

    @Override
    public String convert(Integer number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(int number) {
        return convert((long) number);
    }

    @Override
    public long convert(String value) {
        int result = 0, i = 0;
        value = value.toUpperCase();
        while (i < value.length()) {
            boolean matched = false;
            for (int j = 0; j < ROMAN_NUMS.length; j++) {
                if (value.startsWith(ROMAN_NUMS[j], i)) {
                    result += ROMAN_VALS[j];
                    i += ROMAN_NUMS[j].length();
                    matched = true;
                    break;
                }
            }
            if (!matched) throw new IllegalArgumentException("Invalid symbol: " + value);
        }
        return result;
    }

}
