package club.banyuan.demo.redis.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.impl.RedisCacheServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheServiceTest{
    @Autowired
    private RedisCacheServiceImpl redisCacheService;

    @Test
    public void getSetTest(){
        redisCacheService.set("key","value");
    }
}