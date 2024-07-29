package com.kparlar.iett.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class MessageLine {

    private String messageLineId;
    private String message;
    private String status;
    private Date createDate;
    private Date update;
}

