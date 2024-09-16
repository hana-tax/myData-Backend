package com.example.mydata.domain.invest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class InvestDTO {
    private String accountNo;          // 계좌 번호
    private int investCode;            // 투자 코드
    private Integer accountType;       // 계좌 유형
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdAt;            // 생성일자
    private Double balance;            // 잔액
    private String userCi;             // 사용자 CI

    // 추가 필드
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dividendDate;         // 배당 발생 일자
    private Double dividendAmount;     // 배당 금액
}
