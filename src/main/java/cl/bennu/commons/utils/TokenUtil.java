package cl.bennu.commons.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public abstract class TokenUtil {

    private static final String BEARER = "Bearer";
    private static final String CLAIM_USER = "preferred_username";
    private static final String CLAIM_ROLES = "roles";

    public static String getUser(String token) {
        String user;
        try {
            if (token.contains(BEARER)) {
                token = token.split(BEARER)[1];
            }

            DecodedJWT decodedJWT = JWT.decode(token.trim());
            user = decodedJWT.getClaim(CLAIM_USER).asString();
            user = user.split("@")[0];
        } catch (Exception e) {
            user = "anonymous";
        }
        return user;
    }

    public static String[] getRoles(String token) {
        String[] profiles;
        try {
            if (token.contains(BEARER)) {
                token = token.split(BEARER)[1];
            }

            DecodedJWT decodedJWT = JWT.decode(token.trim());
            profiles = decodedJWT.getClaim(CLAIM_ROLES).asArray(String.class);
        } catch (Exception e) {
            profiles = null;
        }

        return profiles;
    }

}