package com.bupt.nicetown.service;

import com.bupt.nicetown.pojo.VO.ReportVO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface StatisticService {

    ReportVO getPromoteStatistic(LocalDate startTime, LocalDate endTime, Integer townId);
    ReportVO getSupportStatistic(LocalDate startTime, LocalDate endTime, Integer townId);
}
