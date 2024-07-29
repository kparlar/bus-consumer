package com.kparlar.iett.consumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineDTO {

    @JsonProperty("SHATKODU")
    private String code;
    @JsonProperty("SHATADI")
    private String name;
    @JsonProperty("TARIFE")
    private String recipe;
    @JsonProperty("HAT_UZUNLUGU")
    private double length;
    @JsonProperty("SEFER_SURESI")
    private double duration;

}
