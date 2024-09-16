package com.example.mydata.domain.card.dto;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class CardDTO {
    private Integer id;
    private Long cardCode;          // 카드 코드
    private Date cardCreatedAt;      // 카드 생성 날짜
    private Integer cardType;        // 카드 유형
    private String userCi;           // 사용자 CI

    private int cardHistoryId;
    private Date cardDate;
    private double amount;
    private String merchant;
    private String category;
}
