package com.gf.magic.store.front.controller;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */
@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor

public class CardController {


    private final CardService cardService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card createdCard = cardService.createCard(card);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    @GetMapping("/{cardId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Card> getCardById(@PathVariable Long cardId) {
        Card card = cardService.getCardById(cardId);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    // Add other endpoints for getAllCards, updateCard, and deleteCard
}
