package com.bupt.nicetown.service.impl;

import com.bupt.nicetown.mapper.UserMapper;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;//注入接口
//    难道之前把UserMapper写成interface也是为了现在注入用？
    @Override
    public User findById(int id) {
        return usermapper.findById(id);
    }
}
