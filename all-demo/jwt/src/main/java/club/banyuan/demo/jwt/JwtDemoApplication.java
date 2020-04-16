package club.banyuan.demo.jwt;

import club.banyuan.demo.jwt.service.Impl.TokenServiceImpl;
import club.banyuan.demo.jwt.service.TokenService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "club.banyuan.demo")
public class JwtDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
        TokenService tokenService=new TokenServiceImpl();
    }
}
