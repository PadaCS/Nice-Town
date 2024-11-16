package com.bupt.nicetown.service.impl;

import com.bupt.nicetown.mapper.UserMapper;
import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;//注入接口
    private User user;
//    难道之前把UserMapper写成interface也是为了现在注入用？
    @Override
    public User findById(int id) {
        return usermapper.findById(id);
    }

    @Override
    public User findByName(String name) {
        return usermapper.findByName(name);
    }

    @Override
    public void register(String username, String password, String fullName, String documentType, String documentID, String phoneNumber) {
        usermapper.register(username, password, fullName, documentType, documentID, phoneNumber);
    }

    @Override
    public void update(User user) {
        usermapper.update(user);
    }
}
