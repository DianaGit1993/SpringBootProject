package org.example.service;

import org.example.model.dtos.UserCreateDTO;
import org.example.model.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapUserDTOtoUserEntity(UserCreateDTO userCreateDTO){
        return new UserEntity(userCreateDTO.getFirstName(), userCreateDTO.getLastName(),
                userCreateDTO.getUsername(), userCreateDTO.getEmail(), userCreateDTO.getAge(),
                userCreateDTO.getPassword());
    }

    public UserCreateDTO mapUserEntityToUserDTO(UserEntity userEntity){
        return UserCreateDTO.builder().age(userEntity.getAge()).email(userEntity.getEmail())
                .username(userEntity.getUsername()).firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName()).password(userEntity.getPassword()).build();
    }
}
