package com.kparlar.iett.repository;

import com.kparlar.iett.entity.LineEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LineRepository {

    void upsert(LineEntity lineEntity);
    void upsertAll(List<LineEntity> lineEntities);
}
