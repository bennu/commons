package cl.bennu.commons.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TokenUtilsTest {

    @Test
    void testGetUserValidToken() {
        String token = JWT.create()
                .withClaim("preferred_username", "testuser@example.com")
                .sign(Algorithm.HMAC256("secret"));
        assertEquals("testuser", TokenUtil.getUser(token));
    }

    @Test
    void testGetUserInvalidToken() {
        String token = "invalid.token";
        assertEquals("anonymous", TokenUtil.getUser(token));
    }

    @Test
    void testGetUserTokenWithoutBearer() {
        String token = JWT.create()
                .withClaim("preferred_username", "testuser@example.com")
                .sign(Algorithm.HMAC256("secret"));
        assertEquals("testuser", TokenUtil.getUser(token));
    }

    @Test
    void testGetUserTokenWithBearer() {
        String token = "Bearer " + JWT.create()
                .withClaim("preferred_username", "testuser@example.com")
                .sign(Algorithm.HMAC256("secret"));
        assertEquals("testuser", TokenUtil.getUser(token));
    }

    @Test
    void testGetRolesValidToken() {
        String token = JWT.create()
                .withArrayClaim("roles", new String[]{"ADMIN", "USER"})
                .sign(Algorithm.HMAC256("secret"));
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
        String token = JWT.create()
                .withArrayClaim("roles", new String[]{"ADMIN", "USER"})
                .sign(Algorithm.HMAC256("secret"));
        String[] roles = TokenUtil.getRoles(token);
        assertNotNull(roles);
        assertArrayEquals(new String[]{"ADMIN", "USER"}, roles);
    }

    @Test
    void testGetRolesTokenWithBearer() {
        String token = "Bearer " + JWT.create()
                .withArrayClaim("roles", new String[]{"ADMIN", "USER"})
                .sign(Algorithm.HMAC256("secret"));
        String[] roles = TokenUtil.getRoles(token);
        assertNotNull(roles);
        assertArrayEquals(new String[]{"ADMIN", "USER"}, roles);
    }

    @Test
    void testGetRolesTokenWithMissingClaims() {
        String token = JWT.create().sign(Algorithm.HMAC256("secret"));
        assertNull(TokenUtil.getRoles(token));
    }

}
