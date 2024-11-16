package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // 初始化 Mockito
    }

    @Test
    void testRegister_UsernameExists() {
        // 测试参数
        String username = "pada";
        String password = "pada123";
        String fullName = "测试名";
        String documentType = "身份证";
        String documentID = "123456789012345678";
        String phoneNumber = "12345678901";

        // 模拟用户名已存在的情况
        User existingUser = new User();
        existingUser.setUserName(username);
        when(userService.findByName(username)).thenReturn(existingUser);

        // 调用方法
        Result result = userController.register(username, password, fullName, documentType, documentID, phoneNumber);

        // 验证行为
        verify(userService, times(1)).findByName(username);
        verify(userService, never()).register(anyString(), anyString(), anyString(), anyString(), anyString(), anyString());

        // 断言返回结果
        assertEquals(1, result.getCode());
        assertEquals("用户名已存在，请重新输入", result.getMessage());
    }

//    @Test
//    void testRegister_UsernameDoesNotExist() {
//        // 测试参数
//        String username = "TestUser";
//        String password = "TestUser123";
//        String fullName = "测试用户r";
//        String documentType = "身份证";
//        String documentID = "123456789012345678";
//        String phoneNumber = "12345678901";
//
//        // 模拟用户名不存在的情况
//        when(userService.findByName(username)).thenReturn(null);
//
//        // 调用方法
//        Result result = userController.register(username, password, fullName, documentType, documentID, phoneNumber);
//
//        // 验证行为
//        verify(userService, times(1)).findByName(username);
//        verify(userService, times(1)).register(username, password, fullName, documentType, documentID, phoneNumber);
//
//        // 断言返回结果
//        assertEquals(0, result.getCode());
//        assertEquals("操作成功", result.getMessage());
//    }
}
