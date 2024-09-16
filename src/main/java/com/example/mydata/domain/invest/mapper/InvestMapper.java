package com.example.mydata.domain.invest.mapper;

import com.example.mydata.domain.invest.dto.InvestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InvestMapper {
    @Select("""
        SELECT i.*, 
               d.dividendDate, 
               d.dividendAmount, 
               d.accountNo AS 배당발생계좌번호
        FROM investDb i
        LEFT JOIN dividendIncomeHistory d ON i.accountNo = d.accountNo
        WHERE i.investCode = #{investCode} 
          AND i.userCi = #{userCi}
    """)
    List<InvestDTO> findInvestDataByInvestCodeAndUserCi(@Param("investCode") int investCode, @Param("userCi") String userCi);
}
