package com.example.mydata.domain.invest.service;

import com.example.mydata.domain.invest.dto.InvestDTO;
import com.example.mydata.domain.invest.mapper.InvestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestService {
    private final InvestMapper investMapper;

    @Autowired
    public InvestService(InvestMapper investMapper) {
        this.investMapper = investMapper;
    }

    public List<InvestDTO> getInvestDataByInvestCodeAndUserCi(int investCode, String userCi) {
        return investMapper.findInvestDataByInvestCodeAndUserCi(investCode, userCi);
    }
}
