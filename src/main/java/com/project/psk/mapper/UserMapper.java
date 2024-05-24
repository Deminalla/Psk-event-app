package com.project.psk.mapper;

import com.project.psk.model.dto.User.UserInfoDTO;
import com.project.psk.model.dto.User.UserModifyDTO;
import com.project.psk.model.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserInfoDTO entityToInfoDto(UserEntity userEntity);
    UserEntity createDtoToEntity(UserModifyDTO userModifyDTO);
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
}
