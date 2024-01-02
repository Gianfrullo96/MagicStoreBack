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
public class ImageUris extends JsonAnyObject {
    @JsonProperty("small")
    private String small;
    @JsonProperty("normal")
    private String normal;
    @JsonProperty("large")
    private String large;
    @JsonProperty("png")
    private String png;
    @JsonProperty("art_crop")
    private String artCrop;
    @JsonProperty("border_crop")
    private String borderCrop;
}
