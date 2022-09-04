package com.service;

import com.po.InsuranceRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface InsuranceRoleMenuService {
    //通过角色id查询菜单Id
    public List<InsuranceRoleMenu> getByRoleId(Integer[] rId);
}
