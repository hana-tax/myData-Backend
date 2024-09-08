package com.example.mydata.domain.mydata.controller;

import com.example.mydata.domain.mydata.dto.MyDataEnrollmentRequest;
import com.example.mydata.domain.mydata.service.MyDataProcessingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "MyData")
@RestController
@RequestMapping("/api")
public class MyDataController {
    private final MyDataProcessingService myDataProcessingService;
    @Autowired
    public MyDataController(MyDataProcessingService myDataProcessingService) {
        this.myDataProcessingService = myDataProcessingService;
    }

    // 내 서비스 서버로부터 사용자 데이터를 받는 API
    // 사용자 데이터를 받고 여러 금융사 데이터를 반환하는 API
    @PostMapping("/enroll")
    public ResponseEntity<List<Object>> enrollUser(@RequestBody MyDataEnrollmentRequest request) {
        List<Object> assets = myDataProcessingService.processUserData(request);
        if (assets != null && !assets.isEmpty()) {
            return ResponseEntity.ok(assets);  // 성공 시 금융사 데이터를 반환
        } else {
            return ResponseEntity.status(500).body(null);  // 실패 시 500 에러 반환
        }
    }
}
