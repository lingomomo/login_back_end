package com.practice.p0208manager.mapper;

import com.practice.p0208manager.bean.User;
import com.practice.p0208manager.vo.Limits;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * ユーザ名によって、ユーザ情報を取得する。
     * @param userName　ユーザ名
     * @return　ユーザオブジェクトまたはnull
     */
    User getUserByUserName(String userName);

    /**
     * 入力された項目によって、ユーザ情報を検索する。
     * @param limits　入力された項目
     * @return　ユーザ情報コレクション、またはnull
     */
    List<User> getUserByLimits(Limits limits);
}
