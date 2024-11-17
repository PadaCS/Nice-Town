package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.UserService;
import com.bupt.nicetown.utils.JwtUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //POST是浏览器给我数据
    @PostMapping("/register")
    public Result register(String username,
                           //校验密码格式，防止前端不干活
                           @Pattern(regexp = "^(?=(.*\\d.*){2,})(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,}$",
                                   message = "密码至少6位，必须包含两个数字，并且不能全为大写或小写字母") String password,
                           String FullName,
                           String DocumentType,
                           String DocumentID,
                           String phoneNumber) {
        //前端把一大堆参数返回给我，让我先检查一下你合不合规
        //看看用户名重复不重复
        User u = userService.findByName(username);

        if (u != null) {
            //占用的话报错
            System.out.println("——————————————————————\n检测到用户名已存在\n——————————————————————");
            return Result.error("用户名已存在，请重新输入");
        }else {
            //没占用就注册
            System.out.println("——————————————————————\n注册用户\n——————————————————————");
            System.out.println("username:" + username + "\npassword:" + password + "\nFullName:" + FullName +
                    "\nDocumentType:" + DocumentType + "\nDocumentID:" + DocumentID + "\nphoneNumber:" + phoneNumber);
            userService.register(username, password, FullName, DocumentType, DocumentID, phoneNumber);
            return Result.success();
        }
    }

    //POST是浏览器给我数据
    @PostMapping("/login")
    public Result login(String username,
                        @Pattern(regexp = "^(?=(.*\\d.*){2,})(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,}$",
                                message = "密码格式错误，请重新输入") String password){
        User u = userService.findByName(username);
        if (u != null) {
            if(password.equals(u.getPassword())){
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", u.getUserID());
                claims.put("username", u.getUserName());
                String token = JwtUtil.genToken(claims);
                return Result.success(token);
            }
            return Result.error("用户名或密码错误，请重新输入");
        }
        return Result.error("用户不存在，请重新输入");
    }

    //GET是我给浏览器数据
    @GetMapping("/userinfo")
    public Result<User> userinfo( @RequestHeader(name = "Authorization") String token){
        //从token里解析用户名
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        //根据用户名查询用户信息
        User u = userService.findByName(username);
        return Result.success(u);
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){
        System.out.println("——————————————————————\n接收到的用户\n——————————————————————");
        System.out.println("UserID:" + user.getUserID() + "\nusername:" + user.getUserName() + "\npassword:" + user.getPassword() + "\nFullName:" + user.getFullName() +
                "\nDocumentType:" + user.getDocumentType() + "\nDocumentID:" + user.getDocumentID() + "\nphoneNumber:" + user.getPhonenumber());
        userService.update(user);
        return Result.success();
    }

    @PutMapping("/changePsw")
    public Result changePsw(@RequestHeader(name = "Authorization") String token, @RequestBody Map<String,String> params){

        //从token里解析用户名
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");

        //获取想修改密码的用户
        String OriginPsw = params.get("OriginPsw");
        String NewPsw = params.get("NewPsw");
        User u = userService.findByName(username);

        //比对旧密码
        if(u.getPassword().equals(OriginPsw)){
            //修改密码
            userService.changePsw(NewPsw, username);
            return Result.success();
        }

        return Result.error("旧密码输入错误，请重新输入");
    }
}
