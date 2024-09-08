package com.example.mydata.domain.invest.mapper;

import com.example.mydata.domain.invest.dto.InvestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InvestMapper {
    @Select("SELECT * FROM investDb WHERE investCode = #{investCode} AND userCi = #{userCi}")
    List<InvestDTO> findInvestDataByInvestCodeAndUserCi(@Param("investCode") int investCode, @Param("userCi") String userCi);
}
