package com.bupt.nicetown.service;
import com.bupt.nicetown.pojo.User;
import jakarta.validation.constraints.Pattern;

public interface UserService {
    User findById(int id);
    User findByName(String username);
    void register(String username, String password, String fullName, String documentType, String documentID, String phoneNumber);

}
