package com.example.mydata.domain.bank.mapper;

import com.example.mydata.domain.bank.dto.BankDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BankMapper {
    @Select("""
        SELECT b.accountNo, 
               b.accountType, 
               b.createdAt, 
               b.balance, 
               b.bankCode,
               i.interestDate,         -- 이자 발생 일자
               i.interestAmount,       -- 이자 금액
               NULL AS dividendDate,    -- 배당 발생 일자
               NULL AS dividendAmount    -- 배당 금액
        FROM bankDb b
        LEFT JOIN interestHistory i ON b.accountNo = i.accountNo
        WHERE b.bankCode = #{bankCode} 
          AND b.userCi = #{userCi}

        UNION ALL

        SELECT b.accountNo, 
               b.accountType, 
               b.createdAt, 
               b.balance, 
               b.bankCode,
               NULL AS interestDate,     -- 이자 발생 일자
               NULL AS interestAmount,    -- 이자 금액
               d.dividendDate,           -- 배당 발생 일자
               d.dividendAmount           -- 배당 금액
        FROM bankDb b
        LEFT JOIN dividendHistory d ON b.accountNo = d.accountNo
        WHERE b.bankCode = #{bankCode} 
          AND b.userCi = #{userCi}
    """)
    List<BankDTO> findBankDataByBankCodeAndUserCi(@Param("bankCode") int bankCode, @Param("userCi") String userCi);
}
