package com.practice.p0208manager.mapper;

import com.practice.p0208manager.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByUserName(String userName);
}
