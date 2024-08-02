package com.kparlar.iett.entity;

import lombok.Builder;

@Builder(toBuilder = true)
public record LineEntity(String code, String name, String recipe, double length, double duration){}
