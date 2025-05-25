package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class GreekIonianNumeralSystem implements SpecificNumberSystem {

    private static final LinkedHashMap<String, Integer> SYMBOLS = new LinkedHashMap<>();
    private static final Map<Integer, String> REVERSE = new TreeMap<>(Collections.reverseOrder());

    static {
        // Unidades
        SYMBOLS.put("α", 1);
        SYMBOLS.put("β", 2);
        SYMBOLS.put("γ", 3);
        SYMBOLS.put("δ", 4);
        SYMBOLS.put("ε", 5);
        SYMBOLS.put("ϛ", 6);
        SYMBOLS.put("ζ", 7);
        SYMBOLS.put("η", 8);
        SYMBOLS.put("θ", 9);
        // Decenas
        SYMBOLS.put("ι", 10);
        SYMBOLS.put("κ", 20);
        SYMBOLS.put("λ", 30);
        SYMBOLS.put("μ", 40);
        SYMBOLS.put("ν", 50);
        SYMBOLS.put("ξ", 60);
        SYMBOLS.put("ο", 70);
        SYMBOLS.put("π", 80);
        SYMBOLS.put("ϟ", 90);
        // Centenas
        SYMBOLS.put("ρ", 100);
        SYMBOLS.put("σ", 200);
        SYMBOLS.put("τ", 300);
        SYMBOLS.put("υ", 400);
        SYMBOLS.put("φ", 500);
        SYMBOLS.put("χ", 600);
        SYMBOLS.put("ψ", 700);
        SYMBOLS.put("ω", 800);
        SYMBOLS.put("ϡ", 900);
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
        value = value.toLowerCase();
        long total = 0;
        for (char c : value.toCharArray()) {
            Integer val = SYMBOLS.get(String.valueOf(c));
            if (val == null) throw new IllegalArgumentException("Invalid symbol: " + c);
            total += val;
        }
        return total;
    }

}
