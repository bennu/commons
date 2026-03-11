package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonUtilsTest {

    @Test
    void testDeserializeJsonValid() {
        String json = "{\"name\":\"John\",\"age\":30}";
        Object result = JsonUtils.deserialize(json);
        System.out.println(result);
        assertNotNull(result);
        assertTrue(result instanceof java.util.Map);
        java.util.Map<?,?> map = (java.util.Map<?,?>) result;
        assertEquals("John", map.get("name"));
        assertEquals(30, map.get("age"));
    }

    @Test
    void testDeserializeJsonInvalid() {
        String invalidJson = "{name:John,age:30}";
        Object result = JsonUtils.deserialize(invalidJson);
        assertNull(result);
    }

    @Test
    void testDeserializeJsonEmpty() {
        String emptyJson = "";
        Object result = JsonUtils.deserialize(emptyJson);
        assertNull(result);
    }

    @Test
    void testSerializeJsonValid() {
        java.util.Map<String, Object> map = new java.util.HashMap<>();
        map.put("name", "John");
        map.put("age", 30);
        String json = JsonUtils.serialize(map);
        assertNotNull(json);
        assertTrue(json.contains("\"name\":\"John\""));
        assertTrue(json.contains("\"age\":30"));
    }

    @Test
    void testSerializeJsonNull() {
        String json = JsonUtils.serialize(null);
        assertNull(json);
    }
}

