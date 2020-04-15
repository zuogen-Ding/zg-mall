package service.impl;

import org.springframework.stereotype.Service;
import service.UserService;
import user.JacksonUser;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public JacksonUser getUser(String name) {
        return new JacksonUser(name, ((int)(Math.random()*100000))+"");

    }

    @Override
    public JacksonUser putUser(String name, String password) {
        JacksonUser user = getUser(name);
        user.setPassword(password);
        return user;
    }

    @Override
    public boolean deleteUser(String name) {
        return getUser(name)!=null;
    }
}
