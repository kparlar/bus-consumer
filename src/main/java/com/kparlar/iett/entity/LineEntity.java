package com.kparlar.iett.entity;

import lombok.Builder;

import java.util.Date;

@Builder(toBuilder = true)
public record LineEntity(String code, String messageLineId, String name, String recipe, double length, double duration, Date createDate, Date update){}
