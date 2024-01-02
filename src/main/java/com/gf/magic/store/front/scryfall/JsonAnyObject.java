package com.gf.magic.store.front.scryfall;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/4/23
 */
public class JsonAnyObject implements Serializable {


    @JsonIgnore
    protected final Map<String,Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String,Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    @SuppressWarnings("unused")
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JsonAnyObject)) {
            return false;
        }
        JsonAnyObject that = (JsonAnyObject) o;
        return Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalProperties);
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {
        final StringBuilder sb = new StringBuilder("JsonAnyObject{");
        sb.append("additionalProperties=").append(additionalProperties);
        sb.append('}');
        return sb.toString();
    }
}
