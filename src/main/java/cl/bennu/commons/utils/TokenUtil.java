package cl.bennu.commons.utils;


import io.jsonwebtoken.Jwts;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.util.Base64;
import java.util.List;
import java.util.Map;

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

            String[] jwtBody = token.split("\\.");
            if (jwtBody.length != 3) {
                throw new IllegalArgumentException("Invalid JWT token format");
            }
            byte[] bytes = Base64.getUrlDecoder().decode(jwtBody[1]);

            ObjectMapper mapper = new JsonMapper();
            String json = new String(bytes);
            Map<String, Object> claims = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
            Object rolesClaim = claims.get(CLAIM_USER);
            if (rolesClaim != null) {
                user = rolesClaim.toString();
            } else {
                user = "anonymous";
            }
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
            String[] jwtBody = token.split("\\.");
            if (jwtBody.length != 3) {
                throw new IllegalArgumentException("Invalid JWT token format");
            }
            byte[] bytes = Base64.getUrlDecoder().decode(jwtBody[1]);

            ObjectMapper mapper = new JsonMapper();
            String json = new String(bytes);
            Map<String, Object> claims = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
            Object rolesClaim = claims.get(CLAIM_ROLES);
            if (rolesClaim != null) {
                profiles = ((List<String>) rolesClaim).toArray(String[]::new);
            } else {
                profiles = null;
            }
        } catch (Exception e) {
            profiles = null;
        }

        return profiles;
    }

}