package service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import user.JacksonUser;

public interface UserService {

    @Cacheable(value = "user",key = "'name'")
    JacksonUser getUser(String name);

    @CachePut(value = "user",key = "'name'")
    JacksonUser putUser(String name, String password);

    @CacheEvict(value = "user",key = "#name")
    boolean deleteUser(String name);
}
