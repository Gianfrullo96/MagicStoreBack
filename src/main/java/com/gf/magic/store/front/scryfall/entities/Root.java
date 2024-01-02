package com.gf.magic.store.front.scryfall.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.gf.magic.store.front.scryfall.JsonAnyObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/5/23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Root extends JsonAnyObject {
    @JsonProperty("object")
    private String object;
    @JsonProperty("total_cards")
    private int totalCards;
    @JsonProperty("has_more")
    private boolean hasMore;
    @JsonProperty("next_page")
    private String nextPage;
    @JsonProperty("data")
    private ArrayList<Datum> data;
}
