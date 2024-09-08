package com.example.mydata.domain.mydata.dto;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class MyDataEnrollmentRequest {
    private String userId;
    private String ci;  // 사용자의 신용 정보 (CI)
    private List<Integer> assetCodes;  // 선택된 자산 코드 목록
}
