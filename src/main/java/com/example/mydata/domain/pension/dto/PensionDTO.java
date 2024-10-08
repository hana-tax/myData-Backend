package com.example.mydata.domain.pension.dto;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class PensionDTO {
    private Integer id;
    private Long pensionCode;        // 연금 코드
    private Double amount;           // 금액
    private Date createdAt;          // 생성 날짜
    private Integer pensionType;     // 연금 유형
    private String userCi;           // 사용자 CI
}
