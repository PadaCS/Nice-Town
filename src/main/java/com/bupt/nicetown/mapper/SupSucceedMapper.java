package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.Promote;
import com.bupt.nicetown.pojo.Support;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupSucceedMapper {

    @Insert("INSERT INTO supsucceed (PromoteID, PromoterID, SupportID, SupporterID) " +
            "VALUES (#{promoteID}, #{promoterID}, #{supportID}, #{supporterID})")
    void accept(int promoteID, int promoterID, int supportID, int supporterID);
}
