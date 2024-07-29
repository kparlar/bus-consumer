package com.kparlar.iett.consumer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LineEntity {

    private String code;
    private String name;
    private String recipe;
    private double length;
    private double duration;

}
