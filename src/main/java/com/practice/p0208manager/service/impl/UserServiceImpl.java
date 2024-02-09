package com.practice.p0208manager.service.impl;

import com.practice.p0208manager.bean.User;
import com.practice.p0208manager.mapper.UserMapper;
import com.practice.p0208manager.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String userName, String password) {
        if (StringUtils.isBlank(userName)){
            throw new RuntimeException("ユーザ名を空にできません");
        }
        if (StringUtils.isBlank(password)){
            throw new RuntimeException("暗証番号を空にできません");
        }
        User user = userMapper.getUserByUserName(userName);
        if(user==null){
            throw new RuntimeException("ユーザ名は間違いました");
        }
        if (!user.getPassword().equals(DigestUtils.md5Hex(password))){
            throw new RuntimeException("暗証番号は間違いました");
        }
        user.setPassword(null);
        return user;
    }
}
