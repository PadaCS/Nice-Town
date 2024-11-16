package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.UserService;
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
    public Result register(String username, String password, String FullName, String DocumentType, String DocumentID, String phoneNumber) {
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
