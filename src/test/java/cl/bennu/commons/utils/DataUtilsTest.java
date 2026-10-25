package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DataUtilsTest {

    @Test
    void testIsEmptyNull() {
        assertTrue(DataUtils.isEmpty(null));
    }

    @Test
    void testIsEmptyCollection() {
        assertTrue(DataUtils.isEmpty(new ArrayList<>()));
        assertTrue(DataUtils.isEmpty(new HashSet<>()));

        assertFalse(DataUtils.isEmpty(List.of("a")));
        assertFalse(DataUtils.isEmpty(Set.of(1)));
    }

    @Test
    void testIsEmptyMap() {
        assertTrue(DataUtils.isEmpty(new HashMap<>()));

        assertFalse(DataUtils.isEmpty(Map.of("key", "value")));
    }

    @Test
    void testIsEmptyCharSequence() {
        assertTrue(DataUtils.isEmpty(""));
        assertTrue(DataUtils.isEmpty(" "));
        assertTrue(DataUtils.isEmpty(new StringBuilder()));

        assertFalse(DataUtils.isEmpty("a"));
        assertFalse(DataUtils.isEmpty(new StringBuilder("a")));
    }

    @Test
    void testIsEmptyArray() {
        assertTrue(DataUtils.isEmpty(new Object[0]));
        assertTrue(DataUtils.isEmpty(new String[0]));
        assertTrue(DataUtils.isEmpty(new int[0]));

        assertFalse(DataUtils.isEmpty(new Object[]{null}));
        assertFalse(DataUtils.isEmpty(new String[]{"a"}));
        assertFalse(DataUtils.isEmpty(new int[]{1}));
    }

    @Test
    void testIsEmptyOtherObjects() {
        assertFalse(DataUtils.isEmpty(0));
        assertFalse(DataUtils.isEmpty(1L));
        assertFalse(DataUtils.isEmpty(Boolean.FALSE));
        assertFalse(DataUtils.isEmpty(new Object()));
    }

}
