package com.example.mydata.domain.publicOffice.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class PublicDTO {
    private Integer id;
    private String userCi;
    private Long publicCode;
    private Long insuranceAmount;
    private Long pensionAmount;
}
