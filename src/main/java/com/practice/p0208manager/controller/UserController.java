package com.practice.p0208manager.controller;

import com.practice.p0208manager.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.p0208manager.service.UserService;
import com.practice.p0208manager.vo.UserResult;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public UserResult login(String userName,String password){
        User user=userService.login(userName,password);
        return UserResult.ok(user);
    }
}
