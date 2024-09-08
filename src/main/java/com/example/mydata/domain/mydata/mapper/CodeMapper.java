package com.example.mydata.domain.mydata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CodeMapper {
    @Select("SELECT codeCategory FROM codes WHERE code = #{code}")
    String getCodeCategoryByCode(int code);
}
