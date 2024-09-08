package com.example.mydata.domain.bank.dto;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class BankDTO {
    private int bankCode;              // 은행 코드
    private Double interestIncome;     // 이자 소득
    private Double dividendIncome;     // 배당 소득
    private Integer accountType;       // 계좌 유형
    private Date createdAt;            // 생성일자
    private String accountNo;          // 계좌 번호
    private Double balance;            // 잔액
    private String userCi;             // 사용자 CI
}
