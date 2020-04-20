package club.banyuan.demo.authorization.service;

import java.util.Map;

public interface TokenService {

    String generateToken(String subject);

    String generateToken(Map<String, Object> claims);

    String parseSubject(String token);

    boolean isExpired(String token);

    long getExpireSec(String token);

    String refreshExpireDate(String token);

    Map<String,Object> parseMap(String token);
}
