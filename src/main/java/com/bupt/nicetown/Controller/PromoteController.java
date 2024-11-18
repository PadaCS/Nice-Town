package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.*;
import com.bupt.nicetown.service.PromoteService;
import com.bupt.nicetown.service.SupportService;
import com.bupt.nicetown.service.TownService;
import com.bupt.nicetown.service.UserService;
import com.bupt.nicetown.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/promote")
public class PromoteController {
    @Autowired
    private PromoteService promoteService;
    @Autowired
    private UserService userService;
    @Autowired
    private TownService townService;
    @Autowired
    private SupportService supportService;

    @PutMapping("/create")
    public Result create(@RequestHeader(name = "Authorization") String token, @RequestBody Promote promote) {

        //解析用户名，获取用户id，赋值给promote
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        User u = userService.findByName(username);
        int UserID = u.getUserID();
        promote.setPromotterID(UserID);

        //控制台输出
        System.out.println(promote);

        //判断乡镇id是否存在。
        if(townService.findTownByID(promote.getTownID()) != null){
            //创建宣传
            promoteService.create(promote);
            return Result.success();
        }
        return Result.error("乡镇不存在");
    }

    @GetMapping("/list")
    public Result<PageBean<Promote>> list(int pageNum,
                                          int pageSize,
                                          @RequestParam(required = false)String promoteType
    ){
        PageBean<Promote> p = promoteService.list(pageNum,pageSize,promoteType);
        return Result.success(p);
    }

    @GetMapping("/listmy")
    public Result<PageBean<Promote>> listmy(int pageNum,
                                            int pageSize,
                                          @RequestHeader(name = "Authorization") String token,
                                          @RequestParam(required = false)String promoteType
    ){
        //解析用户名，获取用户id
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        User u = userService.findByName(username);
        int UserID = u.getUserID();

        PageBean<Promote> p = promoteService.listmy(pageNum,pageSize,promoteType,UserID);
        return Result.success(p);
    }

    @PutMapping("/update")
    public Result update(@RequestHeader(name = "Authorization") String token, @RequestBody Promote promote) {
        //解析用户名，获取用户id，赋值给promote
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        User u = userService.findByName(username);
        int UserID = u.getUserID();
        promote.setPromotterID(UserID);
        //打印一下看看
        System.out.println(promote);

        //判断status是否为未响应（通过`PromoteID`搜索`support`，如果结果!=null，则说明已有响应，返回error信息：不能修改已响应宣传）
        Support s = supportService.findByPromoteID(promote.getPromoteID());
        if(s != null){
            return Result.error("不能修改已响应的宣传");
        }

        //判断乡镇id是否存在，不存在则返回error信息：乡镇不存在。
        if(townService.findTownByID(promote.getTownID()) == null){
            return Result.error("乡镇不存在");
        }

        //后续可能再加一点判断逻辑，判断宣传id是否存在、宣传类型是否符合格式等
        //不过已取消（删除）的宣传是可以修改的。

        //更新宣传
        promoteService.update(promote);
        return Result.success();
    }

    @PutMapping("/delete")
    public Result delete(@RequestBody Promote promote) {
        //打印一下看看
        System.out.println(promote);

        //判断status是否为未响应（通过`PromoteID`搜索`support`，如果结果!=null，则说明已有响应，返回error信息：不能修改已响应宣传）
        Support s = supportService.findByPromoteID(promote.getPromoteID());
        if(s != null){
            return Result.error("不能删除已响应的宣传");
        }

        //删除宣传
        promoteService.delete(promote);
        return Result.success();
    }

}
