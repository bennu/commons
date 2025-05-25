package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class AegeanNumeralSystem implements SpecificNumberSystem {

    private static final LinkedHashMap<String, Long> SYMBOLS = new LinkedHashMap<>();

    static {
        SYMBOLS.put("*", 10_000L); // 𐄫
        SYMBOLS.put("@", 1_000L);  // 𐄢
        SYMBOLS.put("9", 100L);    // 𐄙
        SYMBOLS.put("n", 10L);     // 𐄐
        SYMBOLS.put("|", 1L);      // 𐄇
    }

    @Override
    public String convert(Long number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(long number) {
        if (number <= 0) throw new IllegalArgumentException("Number must be greater than 0");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Long> entry : SYMBOLS.entrySet()) {
            while (number >= entry.getValue()) {
                sb.append(entry.getKey());
                number -= entry.getValue();
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
            String symbol = String.valueOf(c);
            Long num = SYMBOLS.get(symbol);
            if (num == null) throw new IllegalArgumentException("Invalid symbol: " + symbol);
            total += num;
        }
        return total;
    }

}
