package com.example.mydata.domain.card.controller;

import com.example.mydata.domain.card.dto.CardDTO;
import com.example.mydata.domain.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/card")
    public ResponseEntity<List<CardDTO>> getCardData(@RequestParam int cardCode, @RequestParam String userCi) {
        List<CardDTO> cardData = cardService.getCardDataByCardCodeAndUserCi(cardCode, userCi);
        if (cardData != null && !cardData.isEmpty()) {
            return ResponseEntity.ok(cardData);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
