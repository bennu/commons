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
        if (o instanceof Integer id) {
            return Arrays.stream(values()).filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        } else if (o instanceof Map map) {
            Integer id = (Integer) map.get("id");
            return Arrays.stream(values()).filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        } else {
            return null;
        }
    }

}
