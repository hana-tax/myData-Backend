package com.example.mydata.domain.publicOffice.mapper;
import com.example.mydata.domain.publicOffice.dto.PublicDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PublicMapper {
    @Select("SELECT * FROM mydata.pensionDb WHERE pensionCode = #{pensionCode} AND userCi = #{userCi}")
    List<PublicDTO> findPensionDataByPensionCodeAndUserCi(@Param("pensionCode") int pensionCode, @Param("userCi") String userCi);
}
