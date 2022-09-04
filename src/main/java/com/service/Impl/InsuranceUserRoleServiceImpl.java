package com.service.Impl;

import com.mapper.InsuranceUserRoleMapper;
import com.po.InsuranceUserRole;
import com.service.InsuranceUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InsuranceUserRoleServiceImpl implements InsuranceUserRoleService {
    @Autowired
    private InsuranceUserRoleMapper insuranceUserRoleMapper;

    public InsuranceUserRoleMapper getInsuranceUserRoleMapper() {
        return insuranceUserRoleMapper;
    }

    public void setInsuranceUserRoleMapper(InsuranceUserRoleMapper insuranceUserRoleMapper) {
        this.insuranceUserRoleMapper = insuranceUserRoleMapper;
    }


    @Override
    public List<InsuranceUserRole> getByUserId(Integer usId) {
        return insuranceUserRoleMapper.getByUserId(usId);
    }
}
