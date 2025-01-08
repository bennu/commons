package cl.bennu.commons.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static Date cleanDate(Date date) {
        try {
            if (date == null) return null;

            DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            String formatDate = dateFormat.format(date);

            return dateFormat.parse(formatDate);
        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;
    }

    public static Calendar cleanCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));

        return calendar;
    }

    public static void setFinalDayOfMonth(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setFinalHourOfDay(calendar);
    }

    public static void setFinalHourOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
    }

    public static String format(Date date) {
        return format(date, "dd-MM-yyyy HH:mm:ss");
    }

    public static String format(Date date, String pattern) {
        try {
            if (date == null) return null;
            if (pattern == null) pattern = "ddMMyyyy";

            DateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;
    }

    public static Date parse(String date, String pattern) {
        try {
            if (date == null) return null;
            if (pattern == null) pattern = "ddMMyyyy";

            DateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(date);
        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;
    }

    public static long diff(Date d1, Date d2) {
        return diff(d1, d2, ChronoUnit.MONTHS);
    }

    public static long diff(Date d1, Date d2, ChronoUnit chronoUnit) {
        LocalDate ld1 = Instant.ofEpochMilli(d1.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ld2 = Instant.ofEpochMilli(d2.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        return chronoUnit.between(ld1, ld2);
    }

    public static boolean lastDayOfMonth() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Date getDate() {
        LocalDateTime now6 = LocalDateTime.now(ZoneId.of("America/Santiago"));
        return Date.from(now6.toInstant(ZoneOffset.UTC));
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("America/Santiago")));
    }

}
