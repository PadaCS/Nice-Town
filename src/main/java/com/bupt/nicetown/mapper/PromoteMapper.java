package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.PageBean;
import com.bupt.nicetown.pojo.Promote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PromoteMapper {
    @Insert("INSERT INTO Promote (PromotterID, TownID, Theme, Type, Description, images, videos, status) " +
            "VALUES (#{promotterID}, #{townID}, #{theme}, #{promotType}, #{description}, #{images}, #{videos}, 0)")
    void create(Promote promote);

    //使用映射配置文件写这段sql
    List<Promote> listmy(String promoteType, int userID);
    List<Promote> list(String promoteType);
}