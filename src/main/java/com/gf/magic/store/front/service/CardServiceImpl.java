package com.gf.magic.store.front.service;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */

@Service
public class CardServiceImpl implements CardService{


    @Autowired
    private CardRepo cardRepository;

    @Override
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElse(null);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card updateCard(Long cardId, Card updatedCard) {
        Optional<Card> cardToUpdateOpt = cardRepository.findById(cardId);
        if (cardToUpdateOpt.isPresent()) {
            Card cardToUpdate = cardToUpdateOpt.get();
            cardToUpdate.setName(updatedCard.getName());
            cardToUpdate.setCardSet(updatedCard.getCardSet());
            cardToUpdate.setRarity(updatedCard.getRarity());
            cardToUpdate.setType(updatedCard.getType());
            cardToUpdate.setImageUrl(updatedCard.getImageUrl());
            cardToUpdate.setPrice(updatedCard.getPrice());
            cardToUpdate.setQuantity(updatedCard.getQuantity());
            return cardRepository.save(cardToUpdate);
        }
        return null;
    }

    @Override
    public void deleteCard(Long cardId) {
        cardRepository.deleteById(cardId);
    }
    @Override
    public void testFunc(){
        System.out.println("helloworld");
    }

}
