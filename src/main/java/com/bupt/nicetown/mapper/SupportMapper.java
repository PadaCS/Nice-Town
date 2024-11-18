package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.SupSucceed;
import com.bupt.nicetown.pojo.Support;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SupportMapper {
    @Select("select * from support where PromoteID = #{promoteID}")
    Support findByPromoteID(int promoteID);

    @Insert("INSERT INTO Support (PromoteID, UserID, Description, images, videos, status) " +
            "VALUES (#{promoteID}, #{userID}, #{supDescrip}, #{images}, #{videos}, 0)")
    void create(Support support);

    @Select("select * from support where PromoteID=#{promoteID} and status='0'")
    List<Support> list(int promoteID);

    @Select("select * from support where UserID=#{userID}")
    List<Support> listmy(int userID);
}
