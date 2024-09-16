package com.example.mydata.domain.bank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class BankDTO {
    private String accountNo;          // 계좌 번호
    private int bankCode;              // 은행 코드
    private Double interestIncome;     // 이자 소득
    private Double dividendIncome;     // 배당 소득
    private Integer accountType;       // 계좌 유형
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdAt;            // 생성일자
    private Double balance;            // 잔액
    private String userCi;             // 사용자 CI

    // 추가 필드
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date interestDate;         // 이자 발생 일자
    private Double interestAmount;     // 이자 금액
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dividendDate;         // 배당 발생 일자
    private Double dividendAmount;     // 배당 금액
}
