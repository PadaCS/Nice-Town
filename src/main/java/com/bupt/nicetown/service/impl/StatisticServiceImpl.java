package com.bupt.nicetown.service.impl;

import com.bupt.nicetown.mapper.StatisticMapper;
import com.bupt.nicetown.pojo.VO.ReportVO;
import com.bupt.nicetown.service.StatisticService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticMapper statisticMapper;

    @Override
    public ReportVO getPromoteStatistic(LocalDate startTime, LocalDate endTime , Integer townId) {
        List<LocalDate> dateList = new ArrayList<>();
        dateList.add(startTime);
        while(!startTime.equals(endTime)) {
            startTime = startTime.plusMonths(1);
            dateList.add(startTime);
        }
        StringUtils.join(dateList, ",");
        List<Integer> totalNumList = new ArrayList<>();
        for(LocalDate date : dateList) {
            LocalDateTime begin = LocalDateTime.of(date, LocalTime.MIN);
            LocalDate lastDayOfMonth = date.withDayOfMonth(date.lengthOfMonth());  // 获取该月最后一天
            LocalDateTime end = LocalDateTime.of(lastDayOfMonth, LocalTime.MAX);  // 设置为最后一天的23:59:59.999999999
            Map map = new HashMap();
            map.put("begin",begin);
            map.put("end",end);
            map.put("townId",townId);
            int totalNum = statisticMapper.sumByMap(map);
            totalNumList.add(totalNum);
        }

        return ReportVO.builder()
                .dateList(StringUtils.join(dateList, ","))
                .totalNumList(StringUtils.join(totalNumList, ","))
                .build();
    }

    @Override
    public ReportVO getSupportStatistic(LocalDate startTime, LocalDate endTime, Integer townId) {
        List<LocalDate> dateList = new ArrayList<>();
        dateList.add(startTime);
        while (!startTime.equals(endTime)) {
            startTime = startTime.plusMonths(1);
            dateList.add(startTime);
        }

        StringUtils.join(dateList, ",");
        List<Integer> totalNumList = new ArrayList<>();

        for (LocalDate date : dateList) {
            // 计算开始时间为当月1号的00:00:00
            LocalDateTime begin = LocalDateTime.of(date, LocalTime.MIN);

            // 计算结束时间为当月最后一天的23:59:59.999999999
            LocalDate lastDayOfMonth = date.withDayOfMonth(date.lengthOfMonth());  // 获取该月最后一天
            LocalDateTime end = LocalDateTime.of(lastDayOfMonth, LocalTime.MAX);  // 设置为最后一天的23:59:59.999999999


            // 调用 Mapper 获取符合条件的数据
            Map<String, Object> map = new HashMap<>();
            map.put("begin", begin);
            map.put("end", end);
            map.put("townId", townId);

            int totalNum = statisticMapper.sumSupportUserIDs(map);
            totalNumList.add(totalNum);
        }

        return ReportVO.builder()
                .dateList(StringUtils.join(dateList, ","))
                .totalNumList(StringUtils.join(totalNumList, ","))
                .build();
    }
}
