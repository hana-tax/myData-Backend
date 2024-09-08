package com.example.mydata.domain.bank.controller;

import com.example.mydata.domain.bank.dto.BankDTO;
import com.example.mydata.domain.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/bank")
    public ResponseEntity<List<BankDTO>> getBankData(@RequestParam int bankCode, @RequestParam String userCi) {
        List<BankDTO> bankData = bankService.getBankDataByBankCodeAndUserCi(bankCode, userCi);
        if (bankData != null && !bankData.isEmpty()) {
            return ResponseEntity.ok(bankData);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
