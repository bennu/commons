package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class EgyptianNumeralSystem implements SpecificNumberSystem {

    private static final LinkedHashMap<String, Long> SYMBOLS = new LinkedHashMap<>();

    static {
        SYMBOLS.put("#", 1_000_000L);
        SYMBOLS.put("~", 100_000L);
        SYMBOLS.put("*", 10_000L);
        SYMBOLS.put("@", 1_000L);
        SYMBOLS.put("9", 100L);
        SYMBOLS.put("n", 10L);
        SYMBOLS.put("|", 1L);
    }

    @Override
    public String convert(Long number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(long number) {
        if (number <= 0) throw new IllegalArgumentException("Number must be greater than 0");

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Long> entry : SYMBOLS.entrySet()) {
            while (number >= entry.getValue()) {
                result.append(entry.getKey());
                number -= entry.getValue();
            }
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
        long result = 0;
        for (char c : value.toCharArray()) {
            String symbol = String.valueOf(c);
            if (!SYMBOLS.containsKey(symbol)) {
                throw new IllegalArgumentException("Invalid symbol: " + c);
            }
            result += SYMBOLS.get(symbol);
        }

        return result;
    }

}
