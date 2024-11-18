package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.Promote;
import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.Support;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.PromoteService;
import com.bupt.nicetown.service.SupportService;
import com.bupt.nicetown.service.TownService;
import com.bupt.nicetown.service.UserService;
import com.bupt.nicetown.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
