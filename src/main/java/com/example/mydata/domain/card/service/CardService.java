package com.example.mydata.domain.card.service;

import com.example.mydata.domain.card.dto.CardDTO;
import com.example.mydata.domain.card.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardMapper cardMapper;

    @Autowired
    public CardService(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    public List<CardDTO> getCardDataByCardCodeAndUserCi(int cardCode, String userCi) {
        return cardMapper.findCardDataByCardCodeAndUserCi(cardCode, userCi);
    }
}
