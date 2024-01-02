package com.gf.magic.store.front.scryfall.entities;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/5/23
 */


import com.fasterxml.jackson.annotation.JsonProperty;
import com.gf.magic.store.front.scryfall.JsonAnyObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class RelatedUris extends JsonAnyObject {
    @JsonProperty("gatherer")
    private String gatherer;
    @JsonProperty("tcgplayer_infinite_articles")
    private String tcgplayerInfiniteArticles;
    @JsonProperty("tcgplayer_infinite_decks")
    private String tcgplayerInfiniteDecks;
    @JsonProperty("edhrec")
    private String edhrec;
}
