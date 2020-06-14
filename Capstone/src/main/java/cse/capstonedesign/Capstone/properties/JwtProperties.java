package cse.capstonedesign.Capstone.properties;

public class JwtProperties {
    public static final String SECRET = "minholee93"; // jwt token을 hash할 때 사용	
    public static final int EXPIRATION_TIME = 864000000; // token의 validation 기간 : 10 days
    public static final String TOKEN_PREFIX = "Bearer "; // prefix
    public static final String HEADER_STRING = "Authorization"; // Authorization header로 보내짐을 명시
}
