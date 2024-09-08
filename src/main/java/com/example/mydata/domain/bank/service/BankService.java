package com.example.mydata.domain.bank.service;

import com.example.mydata.domain.bank.dto.BankDTO;
import com.example.mydata.domain.bank.mapper.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private final BankMapper bankMapper;

    @Autowired
    public BankService(BankMapper bankMapper) {
        this.bankMapper = bankMapper;
    }

    public List<BankDTO> getBankDataByBankCodeAndUserCi(int bankCode, String userCi) {
        return bankMapper.findBankDataByBankCodeAndUserCi(bankCode, userCi);
    }
}
