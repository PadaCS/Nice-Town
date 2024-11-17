package com.bupt.nicetown.service;
import com.bupt.nicetown.pojo.User;

public interface UserService {
    User findById(int id);
    User findByName(String username);
    void register(String username, String password, String fullName, String documentType, String documentID, String phoneNumber);
    void update(User user);
    void changePsw(String newPsw, String username);
}
