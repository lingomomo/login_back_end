package com.practice.p0208manager.service;

import com.practice.p0208manager.bean.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    /**
     * ユーザ名と暗証番号にもどついて、ログインする。
     * @param userName
     * @param password
     * @return　ユーザオブジェクトまたはnull
     */
    User login(String userName, String password);


}
