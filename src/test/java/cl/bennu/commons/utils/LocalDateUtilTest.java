package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LocalDateUtilTest {

    @Test
    void testToLocalDateTimeWithPattern() {
        assertEquals(LocalDateTime.of(2024, 2, 5, 0, 0), LocalDateUtil.toLocalDateTime("2024-02-05", "yyyy-MM-dd"));
        assertNull(LocalDateUtil.toLocalDateTime(null, "yyyy-MM-dd"));
        assertNull(LocalDateUtil.toLocalDateTime("", "yyyy-MM-dd"));
        assertThrows(DateTimeParseException.class, () -> LocalDateUtil.toLocalDateTime("05/02/2024", "yyyy-MM-dd"));
    }

    @Test
    void testToLocalDateTimeDefaultPattern() {
        assertNull(LocalDateUtil.toLocalDateTime((String) null));
    }

    @Test
    void testToLocalDateTimeDefaultPatternKeepsTime() {
        assertEquals(LocalDateTime.of(2024, 2, 5, 10, 30, 15), LocalDateUtil.toLocalDateTime("05/02/2024T10:30:15"));
    }

    @Test
    void testToLocalDateTimeFromDate() {
        LocalDateTime expected = LocalDateTime.of(2024, 2, 5, 10, 30, 15);
        Date date = Date.from(expected.atZone(ZoneId.systemDefault()).toInstant());
        assertEquals(expected, LocalDateUtil.toLocalDateTime(date));
    }

    @Test
    void testIsValidDateFormat() {
        assertTrue(LocalDateUtil.isValidDateFormat("05-02-2024"));
        assertFalse(LocalDateUtil.isValidDateFormat("5-2-2024"));
        assertFalse(LocalDateUtil.isValidDateFormat("05/02/2024"));
        assertFalse(LocalDateUtil.isValidDateFormat("2024-02-05"));
        assertFalse(LocalDateUtil.isValidDateFormat(""));
    }

    @Test
    void testToLocalDate() {
        assertEquals(LocalDate.of(2024, 2, 5), LocalDateUtil.toLocalDate("05/02/2024", "dd/MM/yyyy"));
        assertNull(LocalDateUtil.toLocalDate(null, "dd/MM/yyyy"));
        assertNull(LocalDateUtil.toLocalDate("", "dd/MM/yyyy"));
    }

    @Test
    void testToDateFromLocalDate() {
        Date date = LocalDateUtil.toDate(LocalDate.of(2024, 2, 5));
        assertEquals(LocalDate.of(2024, 2, 5).atStartOfDay(ZoneId.systemDefault()).toInstant(), date.toInstant());
    }

    @Test
    void testToDateFromLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 2, 5, 10, 30, 15);
        Date date = LocalDateUtil.toDate(localDateTime);
        assertEquals(localDateTime, LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }

}
