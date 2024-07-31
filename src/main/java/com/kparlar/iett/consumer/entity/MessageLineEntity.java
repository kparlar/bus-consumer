package com.kparlar.iett.consumer.entity;

import lombok.Builder;

import java.util.Date;


@Builder(toBuilder = true)
public record MessageLineEntity(String messageLineId, String message, String status, Date createDate, Date update){}
