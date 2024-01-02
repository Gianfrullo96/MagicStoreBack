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
public class CardFace extends JsonAnyObject {
    @JsonProperty("object")
    private String object;
    @JsonProperty("name")
    private String name;
    @JsonProperty("mana_cost")
    private String manaCost;
    @JsonProperty("type_line")
    private String typeLine;
    @JsonProperty("oracle_text")
    private String oracleText;
    @JsonProperty("colors")
    private ArrayList<String> colors;
    @JsonProperty("power")
    private String power;
    @JsonProperty("toughness")
    private String toughness;
    @JsonProperty("flavor_text")
    private String flavorText;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("artist_id")
    private String artistId;
    @JsonProperty("illustration_id")
    private String illustrationId;
    @JsonProperty("image_uris")
    private ImageUris imageUris;
    @JsonProperty("flavor_name")
    private String flavorName;
    @JsonProperty("color_indicator")
    private ArrayList<String> colorIndicator;
    @JsonProperty("defense")
    private String defense;
}
