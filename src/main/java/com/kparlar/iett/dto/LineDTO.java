package com.kparlar.iett.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kparlar.iett.entity.LineEntity;
import lombok.Builder;

@Builder(toBuilder = true)
public record LineDTO( @JsonProperty("SHATKODU") String code, @JsonProperty("SHATADI") String name, @JsonProperty("TARIFE") String recipe,
                       @JsonProperty("HAT_UZUNLUGU") double length, @JsonProperty("SEFER_SURESI")double duration) {
    public LineEntity toEntity(){
        return LineEntity.builder()
                .code(this.code)
                .name(this.name)
                .recipe(this.recipe)
                .length(this.length)
                .duration(this.duration)
                .build();
    }
}
