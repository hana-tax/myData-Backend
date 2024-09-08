package com.example.mydata.domain.invest.controller;

import com.example.mydata.domain.invest.dto.InvestDTO;
import com.example.mydata.domain.invest.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvestController {
    private final InvestService investService;

    @Autowired
    public InvestController(InvestService investService) {
        this.investService = investService;
    }

    @GetMapping("/invest")
    public ResponseEntity<List<InvestDTO>> getInvestData(@RequestParam int investCode, @RequestParam String userCi) {
        List<InvestDTO> investData = investService.getInvestDataByInvestCodeAndUserCi(investCode, userCi);
        if (investData != null && !investData.isEmpty()) {
            return ResponseEntity.ok(investData);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
