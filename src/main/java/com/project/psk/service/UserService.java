package com.project.psk.service;

import com.project.psk.mapper.UserMapper;
import com.project.psk.model.dto.User.UserCreateDTO;
import com.project.psk.model.dto.User.UserInfoDTO;
import com.project.psk.model.dto.User.UserUpdateDTO;
import com.project.psk.model.entity.UserEntity;
import com.project.psk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
@RequestScope
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserInfoDTO getById(UUID id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        return userMapper.entityToInfoDto(userEntity.get());
    }

    @Transactional
    public UserInfoDTO createUser(UserCreateDTO userCreateDTO) {
        return userMapper.entityToInfoDto(
                userRepository.save(
                        userMapper.createDtoToEntity(userCreateDTO)));
    }

    @Transactional
    public UserInfoDTO updateUser(UUID userId, UserUpdateDTO updateUserDTO) {
        Optional<UserEntity> optionalFoundUser = userRepository.findById(userId);
        if(optionalFoundUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UserNotFound");
        }
        UserEntity foundUser = optionalFoundUser.get();

        foundUser.setUserName(updateUserDTO.getUserName());
        foundUser.setFirstName(updateUserDTO.getFirstName());
        foundUser.setLastName(updateUserDTO.getLastName());
        foundUser.setImageBytes(updateUserDTO.getImageBytes());

        return userMapper.entityToInfoDto(
                userRepository.save(foundUser));
    }

    @Transactional
    public void deleteUser(UUID userId) {
        Optional<UserEntity> optionalFoundUser = userRepository.findById(userId);
        if(optionalFoundUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        userRepository.delete(optionalFoundUser.get());
    }
}
