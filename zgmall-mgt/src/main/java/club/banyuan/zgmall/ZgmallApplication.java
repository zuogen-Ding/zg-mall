package club.banyuan.zgmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,},scanBasePackages = "club.banyuan")
public class ZgmallApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZgmallApplication.class, args);
    }
}
