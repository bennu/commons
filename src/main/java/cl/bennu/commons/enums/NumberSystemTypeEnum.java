package cl.bennu.commons.enums;

import cl.bennu.commons.number.*;
import cl.bennu.commons.number.iface.SpecificNumberSystem;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NumberSystemTypeEnum implements cl.bennu.commons.enums.base.BaseEnum {

    //@formatter:off
    POSITIONAL(1, "Positional")
    , ADDITIVE(2, "Additive")
    , MULTIPLICATIVE(3, "Multiplicative")
    , HYBRID(4, "Hybrid")
    , UNARY(5, "Unary")
    , ALPHABETICAL(6, "Alphabetical")
    , LOGOGRAPHIC(7, "Logographic")
    , NOT_POSITIONAL(8, "Not positional")
    , CUNEIFORM(9, "Cuneiform")
    , NUMERICAL_SYLLABIC(10, "Numerical syllabic")
    ;
    //@formatter:on

    NumberSystemTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private final Integer id;
    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static NumberSystemTypeEnum valueOf(Object o) {
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
