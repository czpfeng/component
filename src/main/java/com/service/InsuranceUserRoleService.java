package com.service;

import com.po.InsuranceUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface InsuranceUserRoleService {
    //通过用户id查询角色id
    public List<InsuranceUserRole> getByUserId(Integer usId);
}
