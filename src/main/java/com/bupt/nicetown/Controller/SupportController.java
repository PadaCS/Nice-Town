package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.*;
import com.bupt.nicetown.service.PromoteService;
import com.bupt.nicetown.service.SupportService;
import com.bupt.nicetown.service.TownService;
import com.bupt.nicetown.service.UserService;
import com.bupt.nicetown.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/support")
public class SupportController {
    @Autowired
    private SupportService supportService;
    @Autowired
    private UserService userService;
    @Autowired
    private TownService townService;
    @Autowired
    private PromoteService promoteService;


    @PutMapping("/create")
    public Result create(@RequestHeader(name = "Authorization") String token, @RequestBody Support support) {

        //解析用户名，获取用户id，赋值给support
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        User u = userService.findByName(username);
        int UserID = u.getUserID();
        support.setUserID(UserID);

        //控制台输出
        System.out.println(support);

        //判断宣传id是否存在。
        if(promoteService.findByID(support.getPromoteID()) != null){
            //创建宣传
            supportService.create(support);
            return Result.success();
        }
        return Result.error("宣传不存在");
    }


    @GetMapping("/list")
    public Result<List<Support>> list(int promoteID){
        List<Support> s = supportService.list(promoteID);
        System.out.println("/list查询到的support：" + s.toString());
        return Result.success(s);
    }

    @GetMapping("/listmy")
    public Result<List<Support>> listmy(@RequestHeader(name = "Authorization") String token){
        //解析用户名，获取用户id
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        User u = userService.findByName(username);
        int UserID = u.getUserID();

        List<Support> p = supportService.listmy(UserID);
        return Result.success(p);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Support support) {
        //找到这个id对应的旧助力
        Support origin = supportService.findByID(support.getSupportID());
        if(origin == null){
            return Result.error("助力不存在");
        }
        System.out.println(support);

        //判断逻，如果状态!=0则不能修改。提示错误“只能修改未接受的助力”
        if(origin.getStatus() != 0){
            return Result.error("只能修改未接受的助力");
        }

        //更新助力
        supportService.update(support);
        return Result.success();
    }

    @PutMapping("/delete")
    public Result delete(@RequestBody Support support) {
        //找到这个id对应的旧助力
        Support s = supportService.findByID(support.getSupportID());
        if(s == null){
            return Result.error("助力不存在");
        }
        System.out.println(support);

        //判断逻，如果状态!=0则不能修改。提示错误“只能修改未接受的助力”
        if(s.getStatus() != 0){
            return Result.error("只能删除状态为未接受的助力");
        }

        //更新助力
        supportService.delete(support);
        return Result.success();
    }

    @PutMapping("/operate")
    public Result accept(int promoteID, int supportID, int operation) {
        //先把这俩找到
        Promote promote = promoteService.findByID(promoteID);
        Support support = supportService.findByID(supportID);

        //一些错误处理
        if(promote == null || support == null){
            return Result.error("宣传或助力不存在");
        }

        //赋值用户id
        int promoterID = promote.getPromotterID();
        int supporterID = support.getSupportID();


        if(promote.getStatus() != 0){
            return Result.error("非公开宣传不可操作助力");
        }

        if (support.getStatus() != 0) {
            return Result.error("助力已被接受、拒绝或删除");
        }

        //operation为1是接受，2是拒绝
        return switch (operation) {
            case 1 -> {
                supportService.accept(promoteID, promoterID, supportID, supporterID);
                yield Result.success();
            }
            case 2 -> {
                supportService.deny(supportID);
                yield Result.success();
            }
//            我是真的很想把删除也加进来，但是它实在是不需要promoteID
//            case 3 -> {
//                supportService.delete(support);
//                yield Result.success();
//            }
            default -> Result.error("操作失败");
        };
    }
}
