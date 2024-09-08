package com.example.mydata.domain.loan.controller;

import com.example.mydata.domain.loan.dto.LoanDTO;
import com.example.mydata.domain.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loan")
    public ResponseEntity<List<LoanDTO>> getLoanData(@RequestParam int loanCode, @RequestParam String userCi) {
        List<LoanDTO> loanData = loanService.getLoanDataByLoanCodeAndUserCi(loanCode, userCi);
        if (loanData != null && !loanData.isEmpty()) {
            return ResponseEntity.ok(loanData);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
