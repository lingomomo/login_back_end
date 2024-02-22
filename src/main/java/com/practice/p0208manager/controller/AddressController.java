package com.practice.p0208manager.controller;

import com.practice.p0208manager.service.AddressService;
import com.practice.p0208manager.service.UserService;
import com.practice.p0208manager.vo.AddressOptions;
import com.practice.p0208manager.vo.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @RequestMapping("/getAddressOptions")
    public UserResult getAddressOptions(){
        List<AddressOptions> list = addressService.getAddressOptions();
        return UserResult.ok(list);
    }
}
