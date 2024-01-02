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
public class Preview extends JsonAnyObject {
    @JsonProperty("source")
    private String source;
    @JsonProperty("source_uri")
    private String sourceUri;
    @JsonProperty("previewed_at")
    private String previewedAt;
}
