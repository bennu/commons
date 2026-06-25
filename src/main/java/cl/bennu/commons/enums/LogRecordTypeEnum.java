package cl.bennu.commons.enums;

import cl.bennu.commons.enums.base.BaseEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LogRecordTypeEnum implements BaseEnum {

    //@formatter:off
    INSERT (1, "Creación")
    , UPDATE (2, "Actualización")
    , DELETE (3, "Eliminación")
    , BACKUP (4, "Respaldo")
    , ACTIVE (5, "Activa")
    , DISABLED (6, "Deshabilitada")
    ;
    //@formatter:on

    LogRecordTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private final Integer id;
    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static LogRecordTypeEnum valueOf(Object o) {
        Integer id = EnumIdResolver.extractId(o);
        return EnumIdResolver.fromId(values(), id, LogRecordTypeEnum::getId);
    }

}
