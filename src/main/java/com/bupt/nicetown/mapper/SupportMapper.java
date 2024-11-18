package com.bupt.nicetown.mapper;

import com.bupt.nicetown.pojo.SupSucceed;
import com.bupt.nicetown.pojo.Support;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SupportMapper {
    @Select("select * from support where PromoteID = #{promoteID}")
    Support findByPromoteID(int promoteID);
}
