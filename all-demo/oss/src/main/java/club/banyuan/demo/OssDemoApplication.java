package club.banyuan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "club.banyuan.demo")
public class OssDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssDemoApplication.class,args);
    }
}
