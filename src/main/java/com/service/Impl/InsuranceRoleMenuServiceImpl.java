package com.service.Impl;

import com.mapper.InsuranceRoleMenuMapper;
import com.po.InsuranceRoleMenu;
import com.service.InsuranceRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class InsuranceRoleMenuServiceImpl implements InsuranceRoleMenuService {
    @Autowired
    private InsuranceRoleMenuMapper insuranceRoleMenuMapper;

    public InsuranceRoleMenuMapper getInsuranceRoleMenuMapper() {
        return insuranceRoleMenuMapper;
    }

    public void setInsuranceRoleMenuMapper(InsuranceRoleMenuMapper insuranceRoleMenuMapper) {
        this.insuranceRoleMenuMapper = insuranceRoleMenuMapper;
    }


    @Override
    public List<InsuranceRoleMenu> getByRoleId(Integer[] rId) {
        return insuranceRoleMenuMapper.getByRoleId(rId);
    }
}
