package cl.bennu.commons.utils;

public class Base64Util {
    public static String encode(String value) {
        return java.util.Base64.getEncoder().encodeToString(value.getBytes());
    }

    public static byte[] decode(String value) {
        return java.util.Base64.getDecoder().decode(value);
    }

    public static byte[] decode(byte[] value) {
        return java.util.Base64.getDecoder().decode(value);
    }

    public static String decodeToString(String value) {
        return new String(java.util.Base64.getDecoder().decode(value));
    }
}
