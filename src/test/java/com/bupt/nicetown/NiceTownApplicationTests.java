package com.bupt.nicetown;

import com.bupt.nicetown.Controller.StatisticController;
import com.bupt.nicetown.mapper.StatisticMapper;
import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.VO.ReportVO;
import com.bupt.nicetown.service.StatisticService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class NiceTownApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private StatisticController statisticController;
    @Autowired
    private StatisticService statisticService;
    @Autowired
    private StatisticMapper statisticMapper;
    @Test
    void testPromoteStatistic(){

        LocalDate startDate = LocalDate.of(2024, 10, 1);  // startDate 参数 (2024-10)
        LocalDate endDate = LocalDate.of(2024, 12, 1);
        Integer townId = 2;  // 城镇ID为2
        ReportVO reportVO = statisticService.getPromoteStatistic(startDate, endDate, townId);
        System.out.println(reportVO.getDateList());
        System.out.println(reportVO.getTotalNumList());
    }
    @Test
    void testSupportStatistic(){

        LocalDate startDate = LocalDate.of(2024, 10, 1);  // startDate 参数 (2024-10)
        LocalDate endDate = LocalDate.of(2024, 12, 1);
        Integer townId = 2;  // 城镇ID为2
        ReportVO reportVO = statisticService.getSupportStatistic(startDate, endDate, townId);
        System.out.println(reportVO.getDateList());
        System.out.println(reportVO.getTotalNumList());
    }


}
