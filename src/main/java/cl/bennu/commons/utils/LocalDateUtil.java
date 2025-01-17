package cl.bennu.commons.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

public class LocalDateUtil {

    public static LocalDateTime toLocalDateTime(String date) {
        return toLocalDateTime(date, "dd/MM/yyyy'T'HH:mm:ss");
    }

    public static LocalDateTime toLocalDateTime(String date, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        if (date == null || date.isEmpty()) return null;
        return LocalDate.parse(date, dateTimeFormatter).atStartOfDay();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.from(date.toInstant());
    }

    public static boolean isValidDateFormat(String date) {
        return Pattern.matches("\\d{2}-\\d{2}-\\d{4}", date);
    }

    public static LocalDate toLocalDate(String date, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        if (date == null || date.isEmpty()) return null;
        return LocalDate.parse(date, dateTimeFormatter);
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}
