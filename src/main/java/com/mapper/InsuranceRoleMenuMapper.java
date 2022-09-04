package com.mapper;

import com.po.InsuranceRoleMenu;
import com.po.InsuranceUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsuranceRoleMenuMapper {
    //通过角色id查询菜单Id
    public List<InsuranceRoleMenu> getByRoleId(Integer[] rId);
}
