package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CyrillicNumeralSystem implements SpecificNumberSystem {

    private static final LinkedHashMap<String, Integer> SYMBOLS = new LinkedHashMap<>();
    private static final Map<Integer, String> REVERSE = new TreeMap<>(Collections.reverseOrder());

    static {
        SYMBOLS.put("а", 1);
        SYMBOLS.put("в", 2);
        SYMBOLS.put("г", 3);
        SYMBOLS.put("д", 4);
        SYMBOLS.put("є", 5);
        SYMBOLS.put("ѕ", 6);
        SYMBOLS.put("з", 7);
        SYMBOLS.put("и", 8);
        SYMBOLS.put("ѳ", 9);

        SYMBOLS.put("і", 10);
        SYMBOLS.put("к", 20);
        SYMBOLS.put("л", 30);
        SYMBOLS.put("м", 40);
        SYMBOLS.put("н", 50);
        SYMBOLS.put("ѯ", 60);
        SYMBOLS.put("о", 70);
        SYMBOLS.put("п", 80);
        SYMBOLS.put("ч", 90);

        SYMBOLS.put("р", 100);
        SYMBOLS.put("с", 200);
        SYMBOLS.put("т", 300);
        SYMBOLS.put("у", 400);
        SYMBOLS.put("ф", 500);
        SYMBOLS.put("х", 600);
        SYMBOLS.put("ѱ", 700);
        SYMBOLS.put("ѡ", 800);
        SYMBOLS.put("ц", 900);
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
        if (number <= 0 || number >= 1000)
            throw new IllegalArgumentException("Greek Ionian number must be between 1 and 999");

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
