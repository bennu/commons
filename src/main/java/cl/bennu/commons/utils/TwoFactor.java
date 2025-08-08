package cl.bennu.commons.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Deprecated // Use cl.bennu.commons.twofactor.iface.TwoFactor instead
public class TwoFactor {

    public static String generateMinutelyPassword() {
        return generateMinutelyPassword(null);
    }

    public static String generateMinutelyPassword(Integer length) {
        if (length == null) length = 4;

        if (length < 4 || length > 8) {
            throw new IllegalArgumentException("La longitud debe estar entre 4 y 8.");
        }

        String dateMinuteStr = LocalDateTime.now(ZoneId.of("America/Santiago")).format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        long value = Long.parseLong(dateMinuteStr);
        long mixed = (value * 97 + 31);

        String result = String.valueOf(mixed);
        if (result.length() < length) {
            return String.format("%0" + length + "d", mixed);
        }

        return result.substring(result.length() - length);
    }

}