package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilsTest {

    private static Date date(int year, int month, int day, int hour, int minute, int second) {
        return new GregorianCalendar(year, month - 1, day, hour, minute, second).getTime();
    }

    @Test
    void testCleanDate() {
        assertEquals(date(2024, 2, 15, 0, 0, 0), DateUtils.cleanDate(date(2024, 2, 15, 13, 45, 30)));
        assertNull(DateUtils.cleanDate(null));
    }

    @Test
    void testCleanCalendar() {
        Calendar calendar = DateUtils.cleanCalendar(date(2024, 2, 15, 13, 45, 30));
        assertEquals(2024, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.FEBRUARY, calendar.get(Calendar.MONTH));
        assertEquals(15, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, calendar.get(Calendar.MINUTE));
        assertEquals(0, calendar.get(Calendar.SECOND));
        assertEquals(0, calendar.get(Calendar.MILLISECOND));
    }

    @Test
    void testSetFinalHourOfDay() {
        Calendar calendar = DateUtils.cleanCalendar(date(2024, 2, 15, 13, 45, 30));
        DateUtils.setFinalHourOfDay(calendar);
        assertEquals(15, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(59, calendar.get(Calendar.MINUTE));
        assertEquals(59, calendar.get(Calendar.SECOND));
        assertEquals(999, calendar.get(Calendar.MILLISECOND));
    }

    @Test
    void testSetFinalDayOfMonth() {
        Calendar calendar = DateUtils.cleanCalendar(date(2024, 2, 15, 13, 45, 30));
        DateUtils.setFinalDayOfMonth(calendar);
        assertEquals(29, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.FEBRUARY, calendar.get(Calendar.MONTH));
        assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(999, calendar.get(Calendar.MILLISECOND));
    }

    @Test
    void testFormat() {
        Date date = date(2024, 2, 5, 8, 9, 10);
        assertEquals("05-02-2024 08:09:10", DateUtils.format(date));
        assertEquals("2024/02/05", DateUtils.format(date, "yyyy/MM/dd"));
        assertEquals("05022024", DateUtils.format(date, null));
        assertNull(DateUtils.format(null));
        assertNull(DateUtils.format(date, "invalid pattern"));
    }

    @Test
    void testParse() {
        assertEquals(date(2024, 2, 5, 0, 0, 0), DateUtils.parse("05022024", null));
        assertEquals(date(2024, 2, 5, 8, 9, 10), DateUtils.parse("2024-02-05 08:09:10", "yyyy-MM-dd HH:mm:ss"));
        assertNull(DateUtils.parse(null, "yyyy-MM-dd"));
        assertNull(DateUtils.parse("not a date", "yyyy-MM-dd"));
    }

    @Test
    void testDiff() {
        Date d1 = date(2024, 1, 31, 23, 0, 0);
        Date d2 = date(2024, 4, 30, 1, 0, 0);
        assertEquals(2, DateUtils.diff(d1, d2));
        assertEquals(90, DateUtils.diff(d1, d2, ChronoUnit.DAYS));
        assertEquals(-90, DateUtils.diff(d2, d1, ChronoUnit.DAYS));
        assertEquals(0, DateUtils.diff(d1, d2, ChronoUnit.YEARS));
    }

    @Test
    void testLastDayOfMonth() {
        Calendar now = Calendar.getInstance();
        boolean expected = now.get(Calendar.DAY_OF_MONTH) == now.getActualMaximum(Calendar.DAY_OF_MONTH);
        assertEquals(expected, DateUtils.lastDayOfMonth());
    }

    @Test
    void testGetDate() {
        assertNotNull(DateUtils.getDate());
    }

    @Test
    void testGetCalendar() {
        Calendar calendar = DateUtils.getCalendar();
        assertEquals(ZoneId.of("America/Santiago"), calendar.getTimeZone().toZoneId());
    }

}
