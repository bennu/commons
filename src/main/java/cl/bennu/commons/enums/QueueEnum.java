package cl.bennu.commons.enums;

import cl.bennu.commons.enums.base.BaseEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum QueueEnum implements BaseEnum {

    //@formatter:off
    PENDING (1, "Pendiente")
    , EXECUTION (2, "Ejecución")
    , ERROR  (3, "Error")
    , FINALIZED  (4, "Finalizado")
    , CANCELED  (5, "Cancelado")
    ;
    //@formatter:on

    QueueEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private final Integer id;
    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static QueueEnum valueOf(Object o) {
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
