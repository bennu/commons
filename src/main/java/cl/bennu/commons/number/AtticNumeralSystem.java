package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class AtticNumeralSystem implements SpecificNumberSystem {

    private static final LinkedHashMap<String, Long> SYMBOLS = new LinkedHashMap<>();

    static {
        SYMBOLS.put("ΜΔ", 1_000_000L);
        SYMBOLS.put("ΜΥ", 100_000L);
        SYMBOLS.put("Μ", 10_000L);
        SYMBOLS.put("Χ", 1_000L);
        SYMBOLS.put("Η", 100L);
        SYMBOLS.put("Δ", 10L);
        SYMBOLS.put("Π", 5L);
        SYMBOLS.put("Ι", 1L);
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
        int i = 0;
        value = value.toUpperCase();
        while (i < value.length()) {
            boolean matched = false;
            for (String symbol : SYMBOLS.keySet()) {
                if (value.startsWith(symbol, i)) {
                    result += SYMBOLS.get(symbol);
                    i += symbol.length();
                    matched = true;
                    break;
                }
            }
            if (!matched) throw new IllegalArgumentException("Invalid symbol: " + value);
        }

        return result;
    }

}
