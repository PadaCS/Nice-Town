//package com.bupt.nicetown.Controller;
//
//import com.bupt.nicetown.pojo.*;
//import com.bupt.nicetown.service.PromoteService;
//import com.bupt.nicetown.service.SupportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//public class StatisticController {
//    @Autowired
//    private PromoteService promoteService;
//
//    @Autowired
//    private SupportService supportService;
//
//    @GetMapping("/stats")
//    public Result<Map<String, Map<String, Integer>>> getStats(
//            String startTime,
//            String endTime,
//            @RequestParam(required = false) Integer townID) {
//
//        // 1. 获取符合时间范围和地域的宣传数据
//        List<Promote> promoteList = promoteService.filter(startTime, endTime, townID);
//
//        // 2. 用来存储最终按月份分组的统计结果
//        Map<String, Map<String, Integer>> stats = new HashMap<>();
//
//        // 3. 遍历宣传数据，按月份统计宣传用户数和助力用户数
//        for (Promote promote : promoteList) {
//            // 获取该宣传的月份（假设 promote.getPromoteDate() 返回的是yyyy-MM格式的日期）
//            String month = getMonthFromDate(promote.getPromoteDate());
//
//            // 获取该宣传的推广者ID列表，去重后统计每个用户（promotter）参与了宣传
//            Set<Integer> uniquePromoters = new HashSet<>(promote.getPromotterIDs()); // 去重
//
//            // 初始化该月份的数据（如果没有初始化）
//            stats.putIfAbsent(month, new HashMap<>());
//
//            // 累加该月的宣传用户数
//            Map<String, Integer> monthStats = stats.get(month);
//            monthStats.put("promotionUserCount",
//                    monthStats.getOrDefault("promotionUserCount", 0) + uniquePromoters.size());
//
//            // 获取该宣传的所有助力信息，按promoteID查询参与的助力用户
//            List<Support> supportList = supportService.filter(startTime, endTime, townID, promote.getPromoteID());
//
//            // 获取助力用户ID（去重）
//            Set<Integer> uniqueSupporters = new HashSet<>();
//            for (Support support : supportList) {
//                uniqueSupporters.add(support.getUserID()); // 去重
//            }
//
//            // 累加该月的助力用户数
//            monthStats.put("supportUserCount",
//                    monthStats.getOrDefault("supportUserCount", 0) + uniqueSupporters.size());
//        }
//
//        // 4. 返回最终统计结果
//        return Result.success(stats);
//    }
//}
