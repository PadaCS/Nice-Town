package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where userID = #{id}")
    User findById(int id);

    @Select("select * from user where userName = #{name}")
    User findByName(String name);

    @Insert("INSERT INTO user (UserName, password, UserType, FullName, DocumentType, DocumentID, phonenumber) " +
            "VALUES (#{username}, #{password}, 'normal', #{fullName}, #{documentType}, #{documentID}, #{phoneNumber})")
    void register(String username, String password, String fullName, String documentType, String documentID, String phoneNumber);


//    void login(String username, String password);
}
