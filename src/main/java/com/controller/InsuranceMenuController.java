package com.controller;

import com.po.*;
import com.service.InsuranceMenuService;
import com.service.InsuranceRoleMenuService;
import com.service.InsuranceUserRoleService;
import com.service.InsuranceUserService;
import com.util.DtoUtil;
import com.util.vo.InsuranceIndexMenutvo;
import com.util.vo.InsuranceMenuItemlistvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class InsuranceMenuController {
    @Autowired
    private InsuranceUserService insuranceUserService;
    @Autowired
    private InsuranceUserRoleService insuranceUserRoleService;
    @Autowired
    private InsuranceRoleMenuService insuranceRoleMenuService;
    @Autowired
    private InsuranceMenuService insuranceMenuService;
    private Jedis jedis=new Jedis("127.0.0.1",6379);
    public InsuranceUserService getInsuranceUserService() {
        return insuranceUserService;
    }

    public void setInsuranceUserService(InsuranceUserService insuranceUserService) {
        this.insuranceUserService = insuranceUserService;
    }

    public InsuranceUserRoleService getInsuranceUserRoleService() {
        return insuranceUserRoleService;
    }

    public void setInsuranceUserRoleService(InsuranceUserRoleService insuranceUserRoleService) {
        this.insuranceUserRoleService = insuranceUserRoleService;
    }

    public InsuranceRoleMenuService getInsuranceRoleMenuService() {
        return insuranceRoleMenuService;
    }

    public void setInsuranceRoleMenuService(InsuranceRoleMenuService insuranceRoleMenuService) {
        this.insuranceRoleMenuService = insuranceRoleMenuService;
    }

    public InsuranceMenuService getInsuranceMenuService() {
        return insuranceMenuService;
    }

    public void setInsuranceMenuService(InsuranceMenuService insuranceMenuService) {
        this.insuranceMenuService = insuranceMenuService;
    }
    /***页面加载获取菜单数据****/
    @RequestMapping(value = "/indexMenu")
    public Dto indexMenu(HttpServletRequest request, HttpServletResponse response, @RequestBody InsuranceIndexMenutvo indexMenutvo) {
        System.out.println("页面加载获取菜单数据：" + indexMenutvo.toString());
        //通过账号获取账号Id
        InsuranceUser user=insuranceUserService.getByUserCode(indexMenutvo.getUserCode());
        System.out.println("a:"+user.toString());
        //通过账号id获取角色Id
        List<InsuranceUserRole> userRoleList=insuranceUserRoleService.getByUserId(user.getId());
        System.out.println("b:"+userRoleList.toString());
        //角色对象集合转角色Id数组
        List<Integer> ridList=new ArrayList<>();
        for (int i=0;i<userRoleList.size();i++){
            ridList.add(userRoleList.get(i).getRoleid());
        }
        Integer[] rid=new Integer[ridList.size()];
        ridList.toArray(rid);
        System.out.println("c:"+rid.toString());
        //通过角色Id获取菜单Id
        List<InsuranceRoleMenu> roleMenuList=insuranceRoleMenuService.getByRoleId(rid);
        System.out.println("d:"+roleMenuList.toString());
        //将菜单对象转菜单Id数组
        List<Integer> midList=new ArrayList<>();
        for (int i=0;i<roleMenuList.size();i++){
            midList.add(roleMenuList.get(i).getMenuid());
        }
        Integer[] mid=new Integer[midList.size()];
        midList.toArray(mid);
        System.out.println("e:"+mid.toString());
        //通过菜单Id查询菜单对象
        List<InsuranceMenu> menuList=insuranceMenuService.getByMenuId(mid);
        System.out.println("f:"+menuList.toString());
        /*********拼接前台页面返回值*********/
        List<InsuranceMenuItemlistvo> itemlistvos=new ArrayList<>();
        for (int i=0;i<menuList.size();i++){
            if(menuList.get(i).getPid().equals("0")){
                InsuranceMenuItemlistvo itemlistvo=new InsuranceMenuItemlistvo();
                //生成一级菜单
                itemlistvo.setMouduleurl(menuList.get(i).getUrl());
                itemlistvo.setText(menuList.get(i).getTextcontet());
                itemlistvo.setIndex(menuList.get(i).getId()+"");
                //通过父级id查询子一级菜单数据
                List<InsuranceMenu> menuListPid=insuranceMenuService.getByMenuPid(menuList.get(i).getId());
                List<InsuranceMenuItemlistvo> menuItemlistvoList=new ArrayList<>();
                for (int j=0;j<menuListPid.size();j++){
                    if(!menuListPid.get(j).getPid().equals(0)){
                        InsuranceMenuItemlistvo itemlistvo1=new InsuranceMenuItemlistvo();
                        //生成二级菜单
                        itemlistvo1.setMouduleurl(menuListPid.get(j).getUrl());
                        itemlistvo1.setText(menuListPid.get(j).getTextcontet());
                        itemlistvo1.setIndex(menuListPid.get(j).getId()+"");
                        itemlistvo1.setNodes(null);
                        menuItemlistvoList.add(itemlistvo1);
                    }
                }
                itemlistvo.setNodes(menuItemlistvoList);
                itemlistvos.add(itemlistvo);

            }
        }

        return DtoUtil.returnSuccess("菜单数据获取成功",itemlistvos);
    }
}
