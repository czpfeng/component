package com.service;

import com.po.InsuranceIns;
import com.po.InsuranceMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface InsuranceInsService {
    //查看所有保险(分页)
    public List<InsuranceIns> getAllIns(int page, int rows);
    //查询总记录数
    public int getMaxRow();
    //通过id查询单个保险
    public InsuranceIns getByInsId(Integer id);
}
