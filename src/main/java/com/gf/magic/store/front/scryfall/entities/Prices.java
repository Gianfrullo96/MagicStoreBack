package com.gf.magic.store.front.scryfall.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gf.magic.store.front.scryfall.JsonAnyObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/5/23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Prices extends JsonAnyObject {
    @JsonProperty("usd")
    private String usd;
    @JsonProperty("usd_foil")
    private String usdFoil;
    @JsonProperty("usd_etched")
    private Object usdEtched;
    @JsonProperty("eur")
    private String eur;
    @JsonProperty("eur_foil")
    private String eurFoil;
    @JsonProperty("tix")
    private String tix;
}
