package com.practice.p0208manager.mapper;

import com.practice.p0208manager.bean.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    List<Address> getAddressByParentId(int parentId);
}
