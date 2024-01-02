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
public class PurchaseUris extends JsonAnyObject {
    @JsonProperty("tcgplayer")
    private String tcgplayer;
    @JsonProperty("cardmarket")
    private String cardmarket;
    @JsonProperty("cardhoarder")
    private String cardhoarder;
}
