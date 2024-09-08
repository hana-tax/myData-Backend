package com.example.mydata.domain.loan.mapper;

import com.example.mydata.domain.loan.dto.LoanDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoanMapper {
    @Select("SELECT * FROM loanDb WHERE loanCode = #{loanCode} AND userCi = #{userCi}")
    List<LoanDTO> findLoanDataByLoanCodeAndUserCi(@Param("loanCode") int loanCode, @Param("userCi") String userCi);
}
