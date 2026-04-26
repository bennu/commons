package cl.bennu.commons.utils;

import org.junit.jupiter.api.Test;

import java.security.*;
import java.util.Base64;
import java.util.Map;
import java.util.WeakHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TokenUtilsTest {

    @Test
    void testGetUserValidToken() {
        String token = createTestToken("testuser@example.com", null);
        assertEquals("testuser", TokenUtil.getUser(token));
    }

    @Test
    void testGetUserInvalidToken() {
        String token = "invalid.token";
        assertEquals("anonymous", TokenUtil.getUser(token));
    }

    @Test
    void testGetUserTokenWithoutBearer() {
        String token = createTestToken("testuser@example.com", null);
        assertEquals("testuser", TokenUtil.getUser(token));
    }

    @Test
    void testGetUserTokenWithBearer() {
        String token = createTestToken("testuser@example.com", null);
        assertEquals("testuser", TokenUtil.getUser(token));
    }

    @Test
    void testGetRolesValidToken() {
        String token = createTestToken("testuser", new String[]{"ADMIN", "USER"});
        String[] roles = TokenUtil.getRoles(token);
        assertNotNull(roles);
        assertArrayEquals(new String[]{"ADMIN", "USER"}, roles);
    }

    @Test
    void testGetRolesInvalidToken() {
        String token = "invalid.token";
        assertNull(TokenUtil.getRoles(token));
    }

    @Test
    void testGetRolesTokenWithoutBearer() {
        String token = createTestToken("anounymus", new String[]{"ADMIN", "USER"});
        String[] roles = TokenUtil.getRoles(token);
        assertNotNull(roles);
        assertArrayEquals(new String[]{"ADMIN", "USER"}, roles);
    }

    @Test
    void testGetRolesTokenWithBearer() {
        String token = createTestToken("testuser", new String[]{"ADMIN", "USER"});
        String[] roles = TokenUtil.getRoles(token);
        assertNotNull(roles);
        assertArrayEquals(new String[]{"ADMIN", "USER"}, roles);
    }

    @Test
    void testGetRolesTokenWithMissingClaims() {
        String token = createTestToken(null, null);
        assertNull(TokenUtil.getRoles(token));
    }

    private String createTestToken(String user, String[] roles) {
        Map<String, Object> header = Map.of("alg", "HS256", "typ", "JWT");
        Map<String, Object> claims = new WeakHashMap<>();
        if (roles != null) {
            claims.put("roles", roles);
        }
        if (user != null) {
            claims.put("preferred_username", user);
        }
        String stringHeader = JsonUtils.serialize(header);
        String stringClaims = JsonUtils.serialize(claims);
        String claimsEncoded = Base64.getUrlEncoder().encodeToString(stringClaims.getBytes());
        String headerEncoded = Base64.getUrlEncoder().encodeToString(stringHeader.getBytes());
        String unsignedToken = headerEncoded + "." + claimsEncoded;
        Signature signature;
        KeyPairGenerator keyGen;
        try {
            signature = Signature.getInstance("SHA256withRSA");
            keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
        } catch (java.security.NoSuchAlgorithmException e) {
            return null;
        }

        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        byte[] signed;
        try {
            signature.initSign(privateKey);
            signature.update(unsignedToken.getBytes());
            signed = signature.sign();
        } catch (Exception e) {
            return null;
        }
        String signatureEncoded = Base64.getUrlEncoder().encodeToString(signed);
        return unsignedToken + "." + signatureEncoded;
    }
}
