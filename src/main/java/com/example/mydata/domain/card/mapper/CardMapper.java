package com.example.mydata.domain.card.mapper;

import com.example.mydata.domain.card.dto.CardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CardMapper {
    @Select("SELECT * FROM cardDb WHERE cardCode = #{cardCode} AND userCi = #{userCi}")
    List<CardDTO> findCardDataByCardCodeAndUserCi(@Param("cardCode") int cardCode, @Param("userCi") String userCi);
}
