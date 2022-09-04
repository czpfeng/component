package com.service.Impl;

import com.mapper.InsuranceUserMapper;
import com.po.InsuranceUser;
import com.service.InsuranceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InsuranceUserServiceImpl implements InsuranceUserService {
   @Autowired
    private InsuranceUserMapper insuranceUserMapper;

    public InsuranceUserMapper getInsuranceUserMapper() {
        return insuranceUserMapper;
    }

    public void setInsuranceUserMapper(InsuranceUserMapper insuranceUserMapper) {
        this.insuranceUserMapper = insuranceUserMapper;
    }


    @Override
    public InsuranceUser getByUserCode(String usCode) {
        return insuranceUserMapper.getByUserCode(usCode);
    }
}
