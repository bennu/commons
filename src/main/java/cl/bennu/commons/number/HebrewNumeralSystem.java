package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HebrewNumeralSystem implements SpecificNumberSystem {

    private static final LinkedHashMap<String, Integer> SYMBOLS = new LinkedHashMap<>();
    private static final Map<Integer, String> REVERSE = new TreeMap<>(Collections.reverseOrder());

    static {
        SYMBOLS.put("א", 1);
        SYMBOLS.put("ב", 2);
        SYMBOLS.put("ג", 3);
        SYMBOLS.put("ד", 4);
        SYMBOLS.put("ה", 5);
        SYMBOLS.put("ו", 6);
        SYMBOLS.put("ז", 7);
        SYMBOLS.put("ח", 8);
        SYMBOLS.put("ט", 9);

        SYMBOLS.put("י", 10);
        SYMBOLS.put("כ", 20);
        SYMBOLS.put("ל", 30);
        SYMBOLS.put("מ", 40);
        SYMBOLS.put("נ", 50);
        SYMBOLS.put("ס", 60);
        SYMBOLS.put("ע", 70);
        SYMBOLS.put("פ", 80);
        SYMBOLS.put("צ", 90);

        SYMBOLS.put("ק", 100);
        SYMBOLS.put("ר", 200);
        SYMBOLS.put("ש", 300);
        SYMBOLS.put("ת", 400);
    }

    static {
        SYMBOLS.forEach((k, v) -> REVERSE.put(v, k));
    }

    @Override
    public String convert(Long number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(long number) {
        if (number <= 0 || number >= 500)
            throw new IllegalArgumentException("Greek Ionian number must be between 1 and 499");

        StringBuilder sb = new StringBuilder();
        for (var entry : REVERSE.entrySet()) {
            while (number >= entry.getKey()) {
                sb.append(entry.getValue());
                number -= entry.getKey();
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
        long total = 0;
        for (char c : value.toCharArray()) {
            Integer val = SYMBOLS.get(String.valueOf(c));
            if (val == null) throw new IllegalArgumentException("Invalid symbol: " + c);
            total += val;
        }
        return total;
    }

}
