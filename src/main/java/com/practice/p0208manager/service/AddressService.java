package com.practice.p0208manager.service;

import com.practice.p0208manager.vo.AddressOptions;

import java.util.List;

public interface AddressService {
    /**
     *
     * @return 第一級カテゴリー及びその下の第二級カテゴリー
     */
    List<AddressOptions> getAddressOptions();
}
