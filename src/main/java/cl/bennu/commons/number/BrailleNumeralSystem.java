package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.HashMap;
import java.util.Map;

public class BrailleNumeralSystem implements SpecificNumberSystem {

    private static final char BRAILLE_NUMBER_PREFIX = '⠼'; // U+283C
    private static final Map<Character, Character> BRAILLE_TO_DIGIT = new HashMap<>();
    private static final Map<Character, Character> DIGIT_TO_BRAILLE = Map.of(
            '1', '⠁', '2', '⠃', '3', '⠉', '4', '⠙', '5', '⠑',
            '6', '⠋', '7', '⠛', '8', '⠓', '9', '⠊', '0', '⠚'
    );

    static {
        DIGIT_TO_BRAILLE.forEach((k, v) -> BRAILLE_TO_DIGIT.put(v, k));
    }

    @Override
    public String convert(Long number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(long number) {
        String digits = Long.toString(number);
        StringBuilder result = new StringBuilder();
        result.append(BRAILLE_NUMBER_PREFIX);
        for (char c : digits.toCharArray()) {
            result.append(DIGIT_TO_BRAILLE.get(c));
        }
        return result.toString();
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
        if (value.charAt(0) != BRAILLE_NUMBER_PREFIX) {
            throw new IllegalArgumentException("Braille number prefix missing.");
        }
        StringBuilder digits = new StringBuilder();
        for (int i = 1; i < value.length(); i++) {
            char brailleChar = value.charAt(i);
            Character digit = BRAILLE_TO_DIGIT.get(brailleChar);
            if (digit == null) throw new IllegalArgumentException("Invalid symbol: " + brailleChar);
            digits.append(digit);
        }
        return Long.parseLong(digits.toString());
    }

}
