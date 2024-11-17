package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.Promote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PromoteMapper {
    @Insert("INSERT INTO Promote (PromotterID, TownID, Theme, Type, Description, images, videos, status) " +
            "VALUES (#{promotterID}, #{townID}, #{theme}, #{promotType}, #{description}, #{images}, #{videos}, 0)")
    void create(Promote promote);
}