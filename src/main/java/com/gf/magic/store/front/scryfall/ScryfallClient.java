package com.gf.magic.store.front.scryfall;

import com.gf.magic.store.front.scryfall.entities.Root;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/4/23
 */
public interface ScryfallClient {

    Root getCards() throws Exception;
}
