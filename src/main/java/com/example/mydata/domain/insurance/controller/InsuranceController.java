package com.example.mydata.domain.insurance.controller;

import com.example.mydata.domain.insurance.dto.InsuranceDTO;
import com.example.mydata.domain.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InsuranceController {
    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping("/insurance")
    public ResponseEntity<List<InsuranceDTO>> getInsuranceData(@RequestParam int insuranceCode, @RequestParam String userCi) {
        List<InsuranceDTO> insuranceData = insuranceService.getInsuranceDataByInsuranceCodeAndUserCi(insuranceCode, userCi);
        if (insuranceData != null && !insuranceData.isEmpty()) {
            return ResponseEntity.ok(insuranceData);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
