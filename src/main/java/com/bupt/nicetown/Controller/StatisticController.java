package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.*;
import com.bupt.nicetown.pojo.VO.ReportVO;
import com.bupt.nicetown.service.PromoteService;
import com.bupt.nicetown.service.StatisticService;
import com.bupt.nicetown.service.SupportService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/statistic")
@Slf4j
public class StatisticController {
    @Autowired
    private StatisticService statisticService;
    //推广统计
    @GetMapping("/promoteStatistic")
    public Result<ReportVO> promoteStatistic(@DateTimeFormat(pattern = "yyyy-MM") LocalDate startDate,
                                      @DateTimeFormat(pattern = "yyyy-MM") LocalDate endDate,Integer townId){
        log.info("startDate:{},endDate:{}", startDate, endDate);
        return Result.success(statisticService.getPromoteStatistic(startDate, endDate, townId));
    }
    //助力统计
    @GetMapping("/supportStatistic")
    public Result<ReportVO> supportStatistic(@DateTimeFormat(pattern = "yyyy-MM") LocalDate startDate,
                                      @DateTimeFormat(pattern = "yyyy-MM") LocalDate endDate,Integer townId){

        return Result.success(statisticService.getSupportStatistic(startDate,endDate,townId));
    }

}
