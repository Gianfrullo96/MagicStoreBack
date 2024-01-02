package com.gf.magic.store.front.scryfall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/5/23
 */

@Service
public class CardFillerService {

    private final ScryfallCardFiller scryfallCardFiller;

    @Autowired
    public CardFillerService(ScryfallCardFiller scryfallCardFiller) {
        this.scryfallCardFiller = scryfallCardFiller;
    }

    public void fillCards() throws Exception {
        scryfallCardFiller.fillCards();
    }
}
