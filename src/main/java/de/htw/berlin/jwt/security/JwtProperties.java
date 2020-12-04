package de.htw.berlin.jwt.security;

public class JwtProperties {
    public static final String SECRET = "TESTsectret123";
    public static final int EXPIRATION_TIME = 864000000;

    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
}
