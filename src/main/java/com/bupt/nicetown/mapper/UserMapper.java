package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where userID = #{id}")
    public User findById(int id);

    @Select("select * from user where userName = #{name}")
    public User findByName(String name);

    @Insert("insert into user(UserName, password)values(name, password)")
    public int register(String name, String password);

}
