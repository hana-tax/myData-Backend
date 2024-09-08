package com.example.mydata.domain.insurance.dto;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class InsuranceDTO {
    private Long insuranceCode;      // 보험 코드
    private Double insuranceAmount;   // 보험 금액
    private Date createdAt;           // 생성 날짜
    private Integer insuranceType;    // 보험 유형
    private String userCi;            // 사용자 CI
}
