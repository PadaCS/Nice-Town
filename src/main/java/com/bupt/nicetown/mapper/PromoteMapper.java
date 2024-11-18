package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.Promote;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PromoteMapper {
    @Insert("INSERT INTO Promote (PromotterID, TownID, Theme, PromoteType, Description, images, videos, status) " +
            "VALUES (#{promotterID}, #{townID}, #{theme}, #{promotType}, #{description}, #{images}, #{videos}, 0)")
    void create(Promote promote);

    //使用映射配置文件写这段sql
    List<Promote> listmy(String promoteType, int userID);
    List<Promote> list(String promoteType);

    @Update("update promote set townID=#{townID}, PromoteType=#{promotType}, theme=#{theme}, description=#{description}, images=#{images}, videos=#{videos} where PromotterID=#{promotterID} and promoteID=#{promoteID}")
    void update(Promote promote);

    @Update("UPDATE Promote SET status = -1 WHERE PromoteID = #{promoteID}")
    void delete(Promote promote);

    @Select("select * from promote where PromoteID = #{promoteID}")
    Promote findByID(int promoteID);
}