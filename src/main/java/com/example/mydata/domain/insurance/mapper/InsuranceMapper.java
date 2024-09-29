package com.example.mydata.domain.insurance.mapper;

import com.example.mydata.domain.insurance.dto.InsuranceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InsuranceMapper {
    @Select("SELECT * FROM mydata.insuranceDb WHERE insuranceCode = #{insuranceCode} AND userCi = #{userCi}")
    List<InsuranceDTO> findInsuranceDataByInsuranceCodeAndUserCi(@Param("insuranceCode") int insuranceCode, @Param("userCi") String userCi);
}
