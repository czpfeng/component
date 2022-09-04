package com.mapper;

import com.po.InsuranceUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsuranceUserMapper {
    //通过账号查询用户id
    public InsuranceUser getByUserCode(String usCode);
}
