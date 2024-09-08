package com.example.mydata.domain.invest.dto;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class InvestDTO {
    private Long investCode;          // 투자 코드
    private Double dividendIncome;     // 배당 수익
    private Integer accountType;       // 계좌 유형
    private Date createdAt;            // 생성 날짜
    private String accountNo;          // 계좌 번호
    private Double balance;             // 잔액
    private String userCi;             // 사용자 CI
}
