package cl.bennu.commons.number;

import cl.bennu.commons.number.iface.SpecificNumberSystem;

import java.util.ArrayList;
import java.util.List;

public class MayanNumeralSystem implements SpecificNumberSystem {

    @Override
    public String convert(Long number) {
        if (number == null) throw new IllegalArgumentException("Number cannot be null");

        return convert(number.longValue());
    }

    @Override
    public String convert(long number) {
        if (number < 0) throw new IllegalArgumentException("Number must be greater than 0");

        if (number == 0) return "0";

        List<String> levels = new ArrayList<>();
        while (number > 0) {
            int digit = (int) (number % 20);
            if (digit == 0) {
                levels.add("0");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("-".repeat(digit / 5));
                sb.append(".".repeat(digit % 5));
                levels.add(sb.toString());
            }
            number /= 20;
        }

        return String.join(" ", levels);
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
        String[] levels = value.trim().split(" ");
        long result = 0;

        for (String level : levels) {
            long num;
            if (level.equals("0")) {
                num = 0;
            } else {
                num = level.chars().filter(c -> c == '-').count() * 5L +
                        level.chars().filter(c -> c == '.').count();
            }
            result = result * 20 + num;
        }

        return result;
    }

}
