package com.project.psk.mapper;

import com.project.psk.model.dto.User.UserCreateDTO;
import com.project.psk.model.dto.User.UserInfoDTO;
import com.project.psk.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserInfoDTO entityToInfoDto(UserEntity userEntity);
    UserEntity createDtoToEntity(UserCreateDTO userCreateDTO);
}
