package com.project.psk.mapper;

import com.project.psk.model.dto.Event.EventInfoDTO;
import com.project.psk.model.dto.Event.EventModifyDTO;
import com.project.psk.model.entity.EventEntity;
import com.project.psk.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface EventMapper {
    @Mapping(source = "organizer", target = "organizer")
    EventInfoDTO entityToInfoDto(EventEntity eventEntity);

    default UUID map(UserEntity userEntity) {
        return userEntity.getId();
    }
    default byte[] map(String base64String) {
        if (base64String == null) {
            return null;
        }
        return Base64.getDecoder().decode(base64String);
    }
    default String map(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(byteArray);
    }
    @Mapping(target = "organizer", ignore = true)
    EventEntity modifyDtoToEntity(EventModifyDTO eventModifyDTO);
    @Mapping(source = "organizer", target = "organizer")
    List<EventInfoDTO> entityListToInfoDtoList(List<EventEntity> eventEntities);
}
