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
public class AllPart extends JsonAnyObject {
    @JsonProperty("object")
    private String object;
    @JsonProperty("id")
    private String id;
    @JsonProperty("component")
    private String component;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type_line")
    private String typeLine;
    @JsonProperty("uri")
    private String uri;
}
