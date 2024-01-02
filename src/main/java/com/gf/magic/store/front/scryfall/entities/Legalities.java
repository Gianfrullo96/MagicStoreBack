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
public class Legalities extends JsonAnyObject {
    @JsonProperty("standard")
    private String standard;
    @JsonProperty("future")
    private String future;
    @JsonProperty("historic")
    private String historic;
    @JsonProperty("gladiator")
    private String gladiator;
    @JsonProperty("pioneer")
    private String pioneer;
    @JsonProperty("explorer")
    private String explorer;
    @JsonProperty("modern")
    private String modern;
    @JsonProperty("legacy")
    private String legacy;
    @JsonProperty("pauper")
    private String pauper;
    @JsonProperty("vintage")
    private String vintage;
    @JsonProperty("penny")
    private String penny;
    @JsonProperty("commander")
    private String commander;
    @JsonProperty("oathbreaker")
    private String oathbreaker;
    @JsonProperty("brawl")
    private String brawl;
    @JsonProperty("historicbrawl")
    private String historicBrawl;
    @JsonProperty("alchemy")
    private String alchemy;
    @JsonProperty("paupercommander")
    private String pauperCommander;
    @JsonProperty("duel")
    private String duel;
    @JsonProperty("oldschool")
    private String oldschool;
    @JsonProperty("premodern")
    private String premodern;
    @JsonProperty("predh")
    private String predh;
}

