package com.kparlar.iett.consumer.repository;

import com.kparlar.iett.consumer.entity.MessageLineEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageLineRepository {

    void upsert(MessageLineEntity messageLineEntity);
}
