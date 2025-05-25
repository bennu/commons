package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.ArrayList;
import java.util.List;

public class BabylonianNumeralSystem implements SpecificNumberSystem {

    @Override
    public String convert(Long number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(long number) {
        if (number < 0) throw new IllegalArgumentException("Number must be greater than 0");

        if (number == 0) return "0";

        List<String> parts = new ArrayList<>();
        while (number > 0) {
            long digit = number % 60;
            StringBuilder symbol = new StringBuilder();
            symbol.append("^".repeat((int) (digit / 10)));
            symbol.append("|".repeat((int) (digit % 10)));
            parts.add(0, symbol.toString());
            number /= 60;
        }
        return String.join(" ", parts);
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
        if (value.equals("0")) return 0;

        String[] parts = value.split(" ");
        long result = 0;
        for (String group : parts) {
            long num = group.chars().filter(c -> c == '^').count() * 10L +
                    group.chars().filter(c -> c == '|').count();
            result = result * 60 + num;
        }
        return result;
    }

}
