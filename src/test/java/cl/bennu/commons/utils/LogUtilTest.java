package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LogUtilTest {

    static class Data {
        private final String name = "test";
    }

    @Test
    void testCallerClassName() {
        String caller = LogUtil.callerClassName();
        assertTrue(caller.startsWith("["));
        assertTrue(caller.endsWith("] --- "));
    }

    @Test
    void testToString() {
        assertEquals("null", LogUtil.toString(null));
        assertEquals("text", LogUtil.toString("text"));
        assertEquals("[1, 2]", LogUtil.toString(List.of(1, 2)));
        assertEquals("{a=1}", LogUtil.toString(Map.of("a", 1)));
        assertTrue(LogUtil.toString(new Data()).contains("name=test"));
    }

    @Test
    void testInsertUpdateDelete() {
        assertDoesNotThrow(() -> LogUtil.insert("user", "entity", new Data()));
        assertDoesNotThrow(() -> LogUtil.insert(null, "entity", new Data()));
        assertDoesNotThrow(() -> LogUtil.update("user", "entity", new Data(), new Data()));
        assertDoesNotThrow(() -> LogUtil.update(" ", "entity", new Data(), new Data()));
        assertDoesNotThrow(() -> LogUtil.delete("user", "entity", new Data()));
        assertDoesNotThrow(() -> LogUtil.delete("", "entity", new Data()));
    }

    @Test
    void testLog() {
        assertDoesNotThrow(() -> LogUtil.log("message"));
        assertDoesNotThrow(() -> LogUtil.log("user", "message"));
        assertDoesNotThrow(() -> LogUtil.log(null, "message"));
        assertDoesNotThrow(() -> LogUtil.log("message", "text", 1, true, new Data()));
    }

    @Test
    void testLogWithJdkObjects() {
        assertDoesNotThrow(() -> LogUtil.log("message", List.of(1, 2), Map.of("a", 1)));
        assertDoesNotThrow(() -> LogUtil.insert("user", "entity", List.of(1, 2)));
    }

    @Test
    void testError() {
        assertDoesNotThrow(() -> LogUtil.error("message", new RuntimeException("error")));
    }

}
