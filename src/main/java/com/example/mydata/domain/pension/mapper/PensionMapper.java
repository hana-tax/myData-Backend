package com.example.mydata.domain.pension.mapper;

import com.example.mydata.domain.pension.dto.PensionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PensionMapper {
    @Select("SELECT * FROM mydata.pensionDb WHERE pensionCode = #{pensionCode} AND userCi = #{userCi}")
    List<PensionDTO> findPensionDataByPensionCodeAndUserCi(@Param("pensionCode") int pensionCode, @Param("userCi") String userCi);
}
