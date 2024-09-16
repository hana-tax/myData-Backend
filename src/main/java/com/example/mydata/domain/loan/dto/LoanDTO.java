package com.example.mydata.domain.loan.dto;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class LoanDTO {
    private Integer id;
    private Long loanCode;          // 대출 코드
    private Double loanAmount;      // 대출 금액
    private Date loanDate;          // 대출 날짜
    private Integer loanType;       // 대출 유형
    private Double interest;         // 이자
    private String userCi;          // 사용자 CI
}
