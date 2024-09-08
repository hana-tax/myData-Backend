package com.example.mydata.domain.bank.mapper;

import com.example.mydata.domain.bank.dto.BankDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BankMapper {
    @Select("SELECT * FROM bankDb WHERE bankCode = #{bankCode} AND userCi = #{userCi}")
    List<BankDTO> findBankDataByBankCodeAndUserCi(@Param("bankCode") int bankCode, @Param("userCi") String userCi);
}
