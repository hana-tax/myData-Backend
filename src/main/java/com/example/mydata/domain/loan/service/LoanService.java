package com.example.mydata.domain.loan.service;

import com.example.mydata.domain.loan.dto.LoanDTO;
import com.example.mydata.domain.loan.mapper.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final LoanMapper investMapper;

    @Autowired
    public LoanService(LoanMapper investMapper) {
        this.investMapper = investMapper;
    }

    public List<LoanDTO> getLoanDataByLoanCodeAndUserCi(int loanCode, String userCi) {
        return investMapper.findLoanDataByLoanCodeAndUserCi(loanCode, userCi);
    }
}
