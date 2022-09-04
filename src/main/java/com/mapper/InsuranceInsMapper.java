package com.mapper;

import com.po.InsuranceIns;
import com.po.InsuranceMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InsuranceInsMapper {
    //查看所有保险(分页)
    public List<InsuranceIns> getAllIns(@Param(value = "page") int page, @Param(value = "rows") int rows);
    //查询总记录数
    public int getMaxRow();
    //通过id查询单个保险
    public InsuranceIns getByInsId(Integer id);
}
