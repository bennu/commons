package cl.bennu.commons.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TwoFactorTypeEnum implements cl.bennu.commons.enums.base.BaseEnum {

    //@formatter:off
    MINUTELY(1, "Minutely")
    , HOURLY(2, "Hourly")
    , DAILY(3, "Daily")
    ;
    //@formatter:on

    TwoFactorTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private final Integer id;
    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TwoFactorTypeEnum valueOf(Object o) {
        Integer id = EnumIdResolver.extractId(o);
        return EnumIdResolver.fromId(values(), id, TwoFactorTypeEnum::getId);
    }

}
