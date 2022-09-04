package com.service;

import com.po.InsuranceUser;

public interface InsuranceUserService {
    //通过账号查询用户id
    public InsuranceUser getByUserCode(String usCode);
}
