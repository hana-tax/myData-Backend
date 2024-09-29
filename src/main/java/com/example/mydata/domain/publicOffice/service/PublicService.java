package com.example.mydata.domain.publicOffice.service;

import com.example.mydata.domain.publicOffice.dto.PublicDTO;
import com.example.mydata.domain.publicOffice.mapper.PublicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicService {
    private final PublicMapper investMapper;

    @Autowired
    public PublicService(PublicMapper investMapper) {
        this.investMapper = investMapper;
    }

    public List<PublicDTO> getPensionDataByPensionCodeAndUserCi(int pensionCode, String userCi) {
        return investMapper.findPensionDataByPensionCodeAndUserCi(pensionCode, userCi);
    }
}
