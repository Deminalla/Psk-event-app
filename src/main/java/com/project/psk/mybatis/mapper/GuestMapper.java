package com.project.psk.mybatis.mapper;

import com.project.psk.model.entity.GuestEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface GuestMapper {

    @Insert("INSERT INTO guests (id, name, email, event_id) VALUES (CAST(#{id} AS UUID), #{name}, #{email}, CAST(#{eventId} AS UUID))")
    void insert(GuestEntity guestEntity);

    @Select("SELECT * FROM guests WHERE id = CAST(#{id} AS UUID)")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email"),
            @Result(property = "eventId", column = "event_id")
    })
    GuestEntity getById(String id);

    @Select("SELECT * FROM guests WHERE event_id = CAST(#{eventId} AS UUID)")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email"),
            @Result(property = "eventId", column = "event_id")
    })
    List<GuestEntity> getAllByEventId(String eventId);

    @Update("UPDATE guests SET name = #{name}, email = #{email}, event_id = CAST(#{eventId} AS UUID) WHERE id = CAST(#{id} AS UUID)")
    void update(GuestEntity guestEntity);

    @Delete("DELETE FROM guests WHERE id = CAST(#{id} AS UUID)")
    void delete(@Param("id") UUID id);
}
