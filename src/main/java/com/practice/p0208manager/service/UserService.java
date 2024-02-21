package com.practice.p0208manager.service;

import com.practice.p0208manager.bean.User;
import com.practice.p0208manager.vo.Limits;

import java.util.List;

public interface UserService {
    /**
     * ユーザ名と暗証番号にもどついて、ログインする。
     * @param userName
     * @param password
     * @return　ユーザオブジェクトまたはnull
     */
    User login(String userName, String password);

    /**
     * 入力された項目によって、ユーザ情報を検索する。
     * @param limits　入力された項目
     * @return　ユーザ情報コレクション
     */
    List<User> showUser(Limits limits);
}
