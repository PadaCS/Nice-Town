package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


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

}
