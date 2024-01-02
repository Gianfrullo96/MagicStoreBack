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
public class Datum extends JsonAnyObject {
    @JsonProperty("object")
    private String object;
    @JsonProperty("id")
    private String id;
    @JsonProperty("oracle_id")
    private String oracleId;
    @JsonProperty("multiverse_ids")
    private ArrayList<Integer> multiverseIds;
    @JsonProperty("mtgo_id")
    private int mtgoId;
    @JsonProperty("tcgplayer_id")
    private int tcgplayerId;
    @JsonProperty("cardmarket_id")
    private int cardmarketId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("released_at")
    private String releasedAt;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("scryfall_uri")
    private String scryfallUri;
    @JsonProperty("layout")
    private String layout;
    @JsonProperty("highres_image")
    private boolean highresImage;
    @JsonProperty("image_status")
    private String imageStatus;
    @JsonProperty("image_uris")
    private ImageUris imageUris;
    @JsonProperty("mana_cost")
    private String manaCost;
    @JsonProperty("cmc")
    private double cmc;
    @JsonProperty("type_line")
    private String typeLine;
    @JsonProperty("oracle_text")
    private String oracleText;
    @JsonProperty("power")
    private String power;
    @JsonProperty("toughness")
    private String toughness;
    @JsonProperty("colors")
    private ArrayList<String> colors;
    @JsonProperty("color_indicator")
    private ArrayList<String> colorIndicator;
    @JsonProperty("color_identity")
    private ArrayList<String> colorIdentity;
    @JsonProperty("keywords")
    private ArrayList<String> keywords;
    @JsonProperty("all_parts")
    private ArrayList<AllPart> allParts;
    @JsonProperty("legalities")
    private Legalities legalities;
    @JsonProperty("games")
    private ArrayList<String> games;
    @JsonProperty("reserved")
    private boolean reserved;
    @JsonProperty("foil")
    private boolean foil;
    @JsonProperty("nonfoil")
    private boolean nonfoil;
    @JsonProperty("finishes")
    private ArrayList<String> finishes;
    @JsonProperty("oversized")
    private boolean oversized;
    @JsonProperty("promo")
    private boolean promo;
    @JsonProperty("reprint")
    private boolean reprint;
    @JsonProperty("variation")
    private boolean variation;
    @JsonProperty("set_id")
    private String setId;
    @JsonProperty("set")
    private String set;
    @JsonProperty("set_name")
    private String setName;
    @JsonProperty("set_type")
    private String setType;
    @JsonProperty("set_uri")
    private String setUri;
    @JsonProperty("set_search_uri")
    private String setSearchUri;
    @JsonProperty("scryfall_set_uri")
    private String scryfallSetUri;
    @JsonProperty("rulings_uri")
    private String rulingsUri;
    @JsonProperty("prints_search_uri")
    private String printsSearchUri;
    @JsonProperty("collector_number")
    private String collectorNumber;
    @JsonProperty("digital")
    private boolean digital;
    @JsonProperty("rarity")
    private String rarity;
    @JsonProperty("card_back_id")
    private String cardBackId;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("artist_ids")
    private ArrayList<String> artistIds;
    @JsonProperty("illustration_id")
    private String illustrationId;
    @JsonProperty("border_color")
    private String borderColor;
    @JsonProperty("frame")
    private String frame;
    @JsonProperty("frame_effects")
    private ArrayList<String> frameEffects;
    @JsonProperty("security_stamp")
    private String securityStamp;
    @JsonProperty("full_art")
    private boolean fullArt;
    @JsonProperty("textless")
    private boolean textless;
    @JsonProperty("booster")
    private boolean booster;
    @JsonProperty("story_spotlight")
    private boolean storySpotlight;
    @JsonProperty("edhrec_rank")
    private int edhrecRank;
    @JsonProperty("preview")
    private Preview preview;
    @JsonProperty("prices")
    private Prices prices;
    @JsonProperty("related_uris")
    private RelatedUris relatedUris;
    @JsonProperty("purchase_uris")
    private PurchaseUris purchaseUris;
    @JsonProperty("arena_id")
    private int arenaId;
    @JsonProperty("card_faces")
    private ArrayList<CardFace> cardFaces;
    @JsonProperty("penny_rank")
    private int pennyRank;
    @JsonProperty("flavor_text")
    private String flavorText;
    @JsonProperty("mtgo_foil_id")
    private int mtgoFoilId;
    @JsonProperty("promo_types")
    private ArrayList<String> promoTypes;
    @JsonProperty("produced_mana")
    private ArrayList<String> producedMana;
    @JsonProperty("watermark")
    private String watermark;
}
