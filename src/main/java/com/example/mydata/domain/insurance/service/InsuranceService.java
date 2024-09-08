package com.example.mydata.domain.insurance.service;

import com.example.mydata.domain.insurance.dto.InsuranceDTO;
import com.example.mydata.domain.insurance.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    private final InsuranceMapper insuranceMapper;

    @Autowired
    public InsuranceService(InsuranceMapper insuranceMapper) {
        this.insuranceMapper = insuranceMapper;
    }

    public List<InsuranceDTO> getInsuranceDataByInsuranceCodeAndUserCi(int insuranceCode, String userCi) {
        return insuranceMapper.findInsuranceDataByInsuranceCodeAndUserCi(insuranceCode, userCi);
    }
}
