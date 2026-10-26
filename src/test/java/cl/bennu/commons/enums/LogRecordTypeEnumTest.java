package cl.bennu.commons.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogRecordTypeEnumTest {

    @Test
    void testBaseEnum() {
        BaseEnumAssertions.assertBaseEnum(LogRecordTypeEnum.values(), LogRecordTypeEnum::valueOf, LogRecordTypeEnum.class);
    }

    @Test
    void testValues() {
        assertEquals(6, LogRecordTypeEnum.values().length);
        assertValue(LogRecordTypeEnum.INSERT, 1, "Creación");
        assertValue(LogRecordTypeEnum.UPDATE, 2, "Actualización");
        assertValue(LogRecordTypeEnum.DELETE, 3, "Eliminación");
        assertValue(LogRecordTypeEnum.BACKUP, 4, "Respaldo");
        assertValue(LogRecordTypeEnum.ACTIVE, 5, "Activa");
        assertValue(LogRecordTypeEnum.DISABLED, 6, "Deshabilitada");
    }

    private static void assertValue(LogRecordTypeEnum value, int id, String name) {
        assertEquals(id, value.getId());
        assertEquals(name, value.getName());
    }

}
