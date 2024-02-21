package com.practice.p0208manager.controller;

import com.practice.p0208manager.bean.User;
import com.practice.p0208manager.vo.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.p0208manager.service.UserService;
import com.practice.p0208manager.vo.UserResult;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public UserResult login(String userName, String password){
        User user = userService.login(userName, password);
        return UserResult.ok(user);
    }
    @RequestMapping("/showUser")
    public UserResult showUser(@RequestBody Limits limits){
        List<User> list =userService.showUser(limits);
        return UserResult.ok(list);
    }
}
