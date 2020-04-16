package club.banyuan.demo.jwt.service.impl;

import club.banyuan.demo.jwt.service.Impl.TokenServiceImpl;
import club.banyuan.demo.jwt.service.TokenService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import javax.xml.bind.DatatypeConverter;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TokenServiceGenerateTest {
    private TokenService tokenService = new TokenServiceImpl();

    @Before
    public void initFiled() {
        ReflectionTestUtils.setField(tokenService, "EXPIRE_SEC", 3600);
        ReflectionTestUtils.setField(tokenService, "SECRET_KEY", "banyuan");
    }

    @Test
    public void generate() {
        String subject = "admin";
        String token = tokenService.generateToken(subject);
        assertEquals(subject, tokenService.parseSubject(token));
    }

    @Test
    public void testExpired() {
        String subject = "test";
        ReflectionTestUtils.setField(tokenService, "EXPIRE_SEC", 1);
        String token = tokenService.generateToken(subject);
        assertTrue(tokenService.isExpired(token));
        assertTrue(tokenService.getExpireSec(token) <= 0);
    }

    // TODO
    @Test
    public void refreshExpiredDateTest() {
        String token = tokenService.generateToken("test");
        String token1 = tokenService.refreshExpireDate(token);
        assertTrue(tokenService.getExpireSec(token) <= tokenService.getExpireSec(token1));
    }

    // TODO
    @Test
    public void generateTokenFromMapTest() {
        String token = tokenService.generateToken("test");
        Map<String, Object> map = tokenService.parseMap(token);
        tokenService.generateToken(map);
    }

    @Test
    public void encodeSecret() {
        String encoded = DatatypeConverter
                .printBase64Binary(DatatypeConverter.parseBase64Binary("banyuan"));
        System.out.println(encoded);
    }
}
