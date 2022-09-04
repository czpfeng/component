package com.service.Impl;

import com.mapper.InsuranceMenuMapper;
import com.po.InsuranceMenu;
import com.service.InsuranceMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class InsuranceMenuServiceImpl implements InsuranceMenuService {
    @Autowired
    private InsuranceMenuMapper insuranceMenuMapper;

    public InsuranceMenuMapper getInsuranceMenuMapper() {
        return insuranceMenuMapper;
    }

    public void setInsuranceMenuMapper(InsuranceMenuMapper insuranceMenuMapper) {
        this.insuranceMenuMapper = insuranceMenuMapper;
    }


    @Override
    public List<InsuranceMenu> getByMenuId(Integer[] mid) {
        return insuranceMenuMapper.getByMenuId(mid);
    }

    @Override
    public List<InsuranceMenu> getByMenuPid(Integer pid) {
        return insuranceMenuMapper.getByMenuPid(pid);
    }
}
