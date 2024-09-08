package com.example.mydata.domain.pension.service;

import com.example.mydata.domain.pension.dto.PensionDTO;
import com.example.mydata.domain.pension.mapper.PensionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PensionService {
    private final PensionMapper investMapper;

    @Autowired
    public PensionService(PensionMapper investMapper) {
        this.investMapper = investMapper;
    }

    public List<PensionDTO> getPensionDataByPensionCodeAndUserCi(int pensionCode, String userCi) {
        return investMapper.findPensionDataByPensionCodeAndUserCi(pensionCode, userCi);
    }
}
