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
public enum NumericBaseEnum implements cl.bennu.commons.enums.base.BaseEnum {

    //@formatter:off
    BINARY(1, 2, "Binary", NumberSystemTypeEnum.POSITIONAL)
    , OCTAL(2, 8, "Octal", NumberSystemTypeEnum.POSITIONAL)
    , DECIMAL(3, 10, "Decimal", NumberSystemTypeEnum.POSITIONAL)
    , HEXADECIMAL(4, 16, "Hexadecimal", NumberSystemTypeEnum.POSITIONAL)

    , TERNARY(5, 3, "Ternary", NumberSystemTypeEnum.POSITIONAL)
    , QUATERNARY(6, 4, "Quaternary", NumberSystemTypeEnum.POSITIONAL)
    , QUINARY(7, 5, "Quinary", NumberSystemTypeEnum.POSITIONAL)
    , SENARY(8, 6, "Senary", NumberSystemTypeEnum.POSITIONAL)
    , SEPTENARY(9, 7, "Septenary", NumberSystemTypeEnum.POSITIONAL)
    , NONARY(10, 9, "Nonary", NumberSystemTypeEnum.POSITIONAL)
    , UNDECIMAL(11, 11, "Undecimal", NumberSystemTypeEnum.POSITIONAL)
    , DUODECIMAL(12, 12, "Duodecimal", NumberSystemTypeEnum.POSITIONAL)
    , VIGESIMAL(13, 20, "Vigesimal", NumberSystemTypeEnum.POSITIONAL)

    , ROMAN(14, new RomanNumeralSystem(),  "Roman", NumberSystemTypeEnum.ADDITIVE)
    , ATTIC(15, new AtticNumeralSystem(),  "Attic", NumberSystemTypeEnum.ADDITIVE)
    , EGYPTIAN(16, new EgyptianNumeralSystem(),  "Egyptian", NumberSystemTypeEnum.ADDITIVE)
    , MAYAN(17, new MayanNumeralSystem(),  "Mayan", NumberSystemTypeEnum.NOT_POSITIONAL)
    , BABYLONIAN(18, new BabylonianNumeralSystem(),  "Babylonian", NumberSystemTypeEnum.ADDITIVE)
    , HEBREW(19, new HebrewNumeralSystem(),  "Hebrew", NumberSystemTypeEnum.ALPHABETICAL)
    , GREEKIONIAN(20, new GreekIonianNumeralSystem(),  "Greek Ionian", NumberSystemTypeEnum.ALPHABETICAL)
    , CYRILLIC(21, new CyrillicNumeralSystem(),  "Cyrillic", NumberSystemTypeEnum.NOT_POSITIONAL)
    , AEGEAN(22, new AegeanNumeralSystem(),  "Aegean", NumberSystemTypeEnum.NOT_POSITIONAL)

    , BASE_13(23, 13, "Base 13", NumberSystemTypeEnum.POSITIONAL)
    , BASE_14(24, 14, "Base 14", NumberSystemTypeEnum.POSITIONAL)
    , BASE_15(25, 15, "Base 15", NumberSystemTypeEnum.POSITIONAL)
    , BASE_17(26, 17, "Base 17", NumberSystemTypeEnum.POSITIONAL)
    , BASE_18(27, 18, "Base 18", NumberSystemTypeEnum.POSITIONAL)
    , BASE_19(28, 19, "Base 19", NumberSystemTypeEnum.POSITIONAL)
    , BASE_21(29, 21, "Base 21", NumberSystemTypeEnum.POSITIONAL)
    , BASE_22(30, 22, "Base 22", NumberSystemTypeEnum.POSITIONAL)
    , BASE_23(31, 23, "Base 23", NumberSystemTypeEnum.POSITIONAL)
    , BASE_24(32, 24, "Base 24", NumberSystemTypeEnum.POSITIONAL)
    , BASE_25(33, 25, "Base 25", NumberSystemTypeEnum.POSITIONAL)
    , BASE_26(34, 26, "Base 26", NumberSystemTypeEnum.POSITIONAL)
    , BASE_27(35, 27, "Base 27", NumberSystemTypeEnum.POSITIONAL)
    , BASE_28(36, 28, "Base 28", NumberSystemTypeEnum.POSITIONAL)
    , BASE_29(37, 29, "Base 29", NumberSystemTypeEnum.POSITIONAL)
    , BASE_30(38, 30, "Base 30", NumberSystemTypeEnum.POSITIONAL)
    , BASE_31(39, 31, "Base 31", NumberSystemTypeEnum.POSITIONAL)
    , BASE_32(40, 32, "Base 32", NumberSystemTypeEnum.POSITIONAL)
    , BASE_33(41, 33, "Base 33", NumberSystemTypeEnum.POSITIONAL)
    , BASE_34(42, 34, "Base 34", NumberSystemTypeEnum.POSITIONAL)
    , BASE_35(43, 35, "Base 35", NumberSystemTypeEnum.POSITIONAL)
    , BASE_36(44, 36, "Base 36", NumberSystemTypeEnum.POSITIONAL)

    , BRAILLE(45, new BrailleNumeralSystem(), "Braille", NumberSystemTypeEnum.NOT_POSITIONAL)
    , MORSE(46, new MorseNumeralSystem(), "Morse", NumberSystemTypeEnum.NOT_POSITIONAL)
    ;
    //@formatter:on

    NumericBaseEnum(Integer id, Integer base, String name, NumberSystemTypeEnum numberSystemTypeEnum) {
        this.id = id;
        this.base = base;
        this.name = name;
        this.specificNumberSystem = null;
        this.numberSystemTypeEnum = numberSystemTypeEnum;
    }

    NumericBaseEnum(Integer id, SpecificNumberSystem specificNumberSystem, String name, NumberSystemTypeEnum numberSystemTypeEnum) {
        this.id = id;
        this.base = null;
        this.name = name;
        this.specificNumberSystem = specificNumberSystem;
        this.numberSystemTypeEnum = numberSystemTypeEnum;
    }

    private final Integer id;
    private final Integer base;
    private final String name;
    private final SpecificNumberSystem specificNumberSystem;
    private final NumberSystemTypeEnum numberSystemTypeEnum;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static NumericBaseEnum valueOf(Object o) {
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
