package com.kparlar.iett.repository;

import com.kparlar.iett.entity.MessageLineEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageLineRepository {

    void upsert(MessageLineEntity messageLineEntity);
}
