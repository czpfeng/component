package com.controller;

import com.po.*;
import com.service.*;
import com.util.DtoUtil;
import com.util.EmptyUtils;
import com.util.ErrorCode;
import com.util.vo.InsurancePagevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/ins")
public class InsuranceInsController {
    @Autowired
    private InsuranceInsService insuranceInsService;

    /***分页查询保险数据****/
    @RequestMapping(value = "/getAllIns")
    public Dto getAllIns(HttpServletRequest request, HttpServletResponse response, @RequestBody InsurancePagevo pagevo) {
        System.out.println("页面加载获取保险数据：" + pagevo.toString());
        if(EmptyUtils.isNotEmpty(pagevo)){
            List<InsuranceIns> insuranceInsList=insuranceInsService.getAllIns(pagevo.getCurrentPage(),pagevo.getPageSize());
            int maxRows=insuranceInsService.getMaxRow();
            /********拼接返回前台的数据begin***********/
            Map<String,Object> map=new HashMap<>();
            map.put("insuranceInsList",insuranceInsList);
            map.put("maxRows",maxRows);
            /********拼接返回前台的数据end***********/
            return DtoUtil.returnSuccess("保险数据获取成功",map);
        }

        return DtoUtil.returnFail("保险数据获取失败", ErrorCode.AUTH_AUTHENTICATION_FAILED);
    }
    /***查询保险单个数据****/
    @RequestMapping(value = "/getByInsId/{id}")
    public Dto getByInsId(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
        System.out.println("页面加载获取保险数据：" + id);
        InsuranceIns ins=insuranceInsService.getByInsId(id);
        if(EmptyUtils.isNotEmpty(ins)){
            return DtoUtil.returnSuccess("保险单个数据获取成功",ins);
        }

        return DtoUtil.returnFail("保险单个数据获取失败", ErrorCode.AUTH_AUTHENTICATION_FAILED);
    }
}
