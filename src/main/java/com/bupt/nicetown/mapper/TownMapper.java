package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.Town;
import com.bupt.nicetown.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TownMapper {
    @Select("select * from town where TownID = #{id}")
    Town findTownByID(int id);
}
