package com.example.mydata.domain.publicOffice.controller;

import com.example.mydata.domain.publicOffice.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PublicController {
private final PublicService publicService;

    @Autowired
    public PublicController(PublicService publicService) {
        this.publicService = publicService;
    }

//    @GetMapping("/public")
//    public ResponseEntity<List<com.example.mydata.domain.PublicDTO>> getPublicData(@RequestParam int publicCode, @RequestParam String userCi) {
//        List<com.example.mydata.domain.PublicDTO> publicData = publicService.getPublicDataByPublicCodeAndUserCi(publicCode, userCi);
//        if (publicData != null && !publicData.isEmpty()) {
//            return ResponseEntity.ok(publicData);
//        } else {
//            return ResponseEntity.status(404).body(null);
//        }
//    }
}
