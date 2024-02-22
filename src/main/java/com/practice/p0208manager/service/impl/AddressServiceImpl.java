package com.practice.p0208manager.service.impl;

import com.practice.p0208manager.bean.Address;
import com.practice.p0208manager.mapper.AddressMapper;
import com.practice.p0208manager.mapper.UserMapper;
import com.practice.p0208manager.service.AddressService;
import com.practice.p0208manager.vo.AddressOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<AddressOptions> getAddressOptions() {
        List<AddressOptions> list = getAddressOptionsAll(0);
        return list;
    }
//   再帰を使用するために、カプセル化メソッド
    public List<AddressOptions> getAddressOptionsAll(int parentId) {
        List<AddressOptions> list = new ArrayList<AddressOptions>();
//第一級カテゴリーを検索する
        List<Address> addressList = addressMapper.getAddressByParentId(parentId);
        if (addressList!=null){
            for (Address address:addressList) {
                AddressOptions option = new AddressOptions();
                option.setId(address.getId());
                System.out.println(option);
                option.setTitle(address.getAddress());
//            再帰のメソッドを使用する
                List<AddressOptions> options = getAddressOptionsAll(option.getId());

                if (options.isEmpty()){
                    option.setChildren(null);
                }else {
                    option.setChildren(options);
                }
                list.add(option);
            }
        }

        return list;
    }
}
