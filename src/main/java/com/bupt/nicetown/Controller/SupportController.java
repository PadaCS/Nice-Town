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
        List<Support> p = supportService.list(promoteID);
        return Result.success(p);
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
        if(supportService.findByID(support.getSupportID()) == null){
            return Result.error("助力不存在");
        }
        Support origin = supportService.findByID(support.getSupportID());
        System.out.println(support);

        //判断逻，如果状态!=0则不能修改。提示错误“只能修改未接受的助力”
        if(origin.getStatus() != 0){
            return Result.error("只能修改未接受的助力");
        }

        //更新助力
        supportService.update(support);
        return Result.success();
    }


}
