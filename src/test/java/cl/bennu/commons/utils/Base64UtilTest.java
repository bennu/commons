package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Base64UtilTest {

    @Test
    void testEncode() {
        String original = "Hello, World!";
        String encoded = Base64Util.encode(original);
        assertEquals("SGVsbG8sIFdvcmxkIQ==", encoded);
    }

    @Test
    void testDecode() {
        String encoded = "SGVsbG8sIFdvcmxkIQ==";
        byte[] decoded = Base64Util.decode(encoded);
        assertArrayEquals("Hello, World!".getBytes(), decoded);
    }

    @Test
    void testDecodeByteArray() {
        byte[] encoded = "SGVsbG8sIFdvcmxkIQ==".getBytes();
        byte[] decoded = Base64Util.decode(encoded);
        assertArrayEquals("Hello, World!".getBytes(), decoded);
    }

    @Test
    void testDecodeToString() {
        String encoded = "SGVsbG8sIFdvcmxkIQ==";
        String decoded = Base64Util.decodeToString(encoded);
        assertEquals("Hello, World!", decoded);
    }

}
