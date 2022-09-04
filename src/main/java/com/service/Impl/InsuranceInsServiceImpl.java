package com.service.Impl;

import com.mapper.InsuranceInsMapper;
import com.mapper.InsuranceMenuMapper;
import com.po.InsuranceIns;
import com.po.InsuranceMenu;
import com.service.InsuranceInsService;
import com.service.InsuranceMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InsuranceInsServiceImpl implements InsuranceInsService {
    @Autowired
    private InsuranceInsMapper insuranceInsMapper;
    @Override
    public List<InsuranceIns> getAllIns(int page, int rows) {
        return insuranceInsMapper.getAllIns(page,rows);
    }

    @Override
    public int getMaxRow() {
        return insuranceInsMapper.getMaxRow();
    }

    @Override
    public InsuranceIns getByInsId(Integer id) {
        return insuranceInsMapper.getByInsId(id);
    }
}
