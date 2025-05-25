package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.HashMap;
import java.util.Map;

public class MorseNumeralSystem implements SpecificNumberSystem {

    private static final Map<Character, String> DIGIT_TO_MORSE = Map.of(
            '0', "-----", '1', ".----", '2', "..---", '3', "...--", '4', "....-",
            '5', ".....", '6', "-....", '7', "--...", '8', "---..", '9', "----."
    );

    private static final Map<String, Character> MORSE_TO_DIGIT = new HashMap<>();

    static {
        DIGIT_TO_MORSE.forEach((k, v) -> MORSE_TO_DIGIT.put(v, k));
    }

    @Override
    public String convert(Long number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(long number) {
        StringBuilder sb = new StringBuilder();
        for (char digit : Long.toString(number).toCharArray()) {
            sb.append(DIGIT_TO_MORSE.get(digit)).append(" ");
        }
        return sb.toString().trim();
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
        String[] codes = value.trim().split(" ");
        StringBuilder digits = new StringBuilder();
        for (String code : codes) {
            Character digit = MORSE_TO_DIGIT.get(code);
            if (digit == null) throw new IllegalArgumentException("Invalid symbol: " + code);
            digits.append(digit);
        }
        return Long.parseLong(digits.toString());
    }

}
