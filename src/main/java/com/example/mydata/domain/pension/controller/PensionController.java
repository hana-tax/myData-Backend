package com.example.mydata.domain.pension.controller;

import com.example.mydata.domain.pension.dto.PensionDTO;
import com.example.mydata.domain.pension.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PensionController {
    private final PensionService pensionService;

    @Autowired
    public PensionController(PensionService pensionService) {
        this.pensionService = pensionService;
    }

    @GetMapping("/pension")
    public ResponseEntity<List<PensionDTO>> getPensionData(@RequestParam int pensionCode, @RequestParam String userCi) {
        List<PensionDTO> pensionData = pensionService.getPensionDataByPensionCodeAndUserCi(pensionCode, userCi);
        if (pensionData != null && !pensionData.isEmpty()) {
            return ResponseEntity.ok(pensionData);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
