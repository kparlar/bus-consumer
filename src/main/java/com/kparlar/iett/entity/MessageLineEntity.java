package com.kparlar.iett.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;

import java.util.Date;


@Builder(toBuilder = true)
public record MessageLineEntity(String messageLineId, JsonNode message, String status, Date createDate, Date update){}
