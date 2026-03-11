package cl.bennu.commons.utils;

import org.apache.commons.lang3.StringUtils;
import tools.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static Object deserialize(String json) {
        if (StringUtils.isBlank(json)) return null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, Object.class);
        } catch (Exception e) {
            return null;
        }
    }

    public static String serialize(Object object) {
        if (object == null) return null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return null;
        }
    }

}
