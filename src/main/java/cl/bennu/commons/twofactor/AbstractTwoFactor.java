package cl.bennu.commons.twofactor;

import cl.bennu.commons.enums.TwoFactorTypeEnum;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public abstract class AbstractTwoFactor {

    public String generate(TwoFactorTypeEnum twoFactorTypeEnum) {
        return generate(twoFactorTypeEnum, null);
    }

    public String generate(TwoFactorTypeEnum twoFactorTypeEnum, Integer length) {
        if (length == null) length = 4;
        if (twoFactorTypeEnum == null) twoFactorTypeEnum = TwoFactorTypeEnum.MINUTELY;

        if (length < 4 || length > 8) {
            throw new IllegalArgumentException("Length must be between 4 and 8.");
        }

        String dateMinuteStr = null;
        Integer multiplier = null;
        Integer addend = null;
        if (TwoFactorTypeEnum.MINUTELY.equals(twoFactorTypeEnum)) {
            dateMinuteStr = LocalDateTime.now(ZoneId.of("America/Santiago")).format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
            multiplier = 97;
            addend = 31;
        } else if (TwoFactorTypeEnum.HOURLY.equals(twoFactorTypeEnum)) {
            dateMinuteStr = LocalDateTime.now(ZoneId.of("America/Santiago")).format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
            multiplier = 83;
            addend = 47;
        } else if (TwoFactorTypeEnum.DAILY.equals(twoFactorTypeEnum)) {
            dateMinuteStr = LocalDateTime.now(ZoneId.of("America/Santiago")).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            multiplier = 73;
            addend = 19;
        } else {
            throw new IllegalArgumentException("Unsupported enum");
        }

        long value = Long.parseLong(dateMinuteStr);
        long mixed = (value * multiplier + addend);

        String result = String.valueOf(mixed);
        if (result.length() < length) {
            return String.format("%0" + length + "d", mixed);
        }

        return result.substring(result.length() - length);
    }


}
