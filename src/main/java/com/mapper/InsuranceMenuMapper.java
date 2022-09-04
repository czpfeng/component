package com.mapper;

import com.po.InsuranceMenu;
import com.po.InsuranceRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsuranceMenuMapper {
    //通过菜单Id查询菜单的对象
    public List<InsuranceMenu> getByMenuId(Integer[] mid);
    //通过菜单父Id查询菜单的对象
    public List<InsuranceMenu> getByMenuPid(Integer pid);
}
