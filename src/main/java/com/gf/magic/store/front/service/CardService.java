package com.gf.magic.store.front.service;

import com.gf.magic.store.front.model.Card;

import java.util.List;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */
public interface CardService {
    Card createCard(Card card);

    Card getCardById(Long cardId);

    List<Card> getAllCards();

    Card updateCard(Long cardId, Card updatedCard);

    void deleteCard(Long cardId);

    void testFunc();
}
