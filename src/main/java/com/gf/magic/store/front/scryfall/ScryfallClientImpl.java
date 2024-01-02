package com.gf.magic.store.front.scryfall;

import com.gf.magic.store.front.scryfall.entities.Root;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/4/23
 */
public class ScryfallClientImpl implements ScryfallClient{
    private final ScryFallRestClientTemplate template;

    public ScryfallClientImpl(String Url) {
        this.template = new ScryFallRestClientTemplate(Url);
    }

    @Override
    public Root getCards() throws  Exception{
        return  template.getCards();
    }

}
