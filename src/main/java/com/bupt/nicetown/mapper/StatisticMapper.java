package com.bupt.nicetown.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface StatisticMapper {
    int sumByMap(Map map);

    int sumSupportUserIDs(Map<String, Object> map);
}
