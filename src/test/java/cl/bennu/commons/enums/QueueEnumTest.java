package cl.bennu.commons.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueEnumTest {

    @Test
    void testBaseEnum() {
        BaseEnumAssertions.assertBaseEnum(QueueEnum.values(), QueueEnum::valueOf, QueueEnum.class);
    }

    @Test
    void testValues() {
        assertEquals(5, QueueEnum.values().length);
        assertValue(QueueEnum.PENDING, 1, "Pendiente");
        assertValue(QueueEnum.EXECUTION, 2, "Ejecución");
        assertValue(QueueEnum.ERROR, 3, "Error");
        assertValue(QueueEnum.FINALIZED, 4, "Finalizado");
        assertValue(QueueEnum.CANCELED, 5, "Cancelado");
    }

    private static void assertValue(QueueEnum value, int id, String name) {
        assertEquals(id, value.getId());
        assertEquals(name, value.getName());
    }

}
