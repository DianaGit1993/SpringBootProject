package org.example.service;

import lombok.Getter;
import lombok.Setter;
import org.example.model.entities.User;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapUserDTOtoUserEntity(UserCreateDTO userCreateDTO){
        User user= new User();
        user.setUserName(userCreateDTO.getUsername());
        user.setPassword(userCreateDTO.getPassword());
        user.setAge(userCreateDTO.getAge());
        user.setEmail(userCreateDTO.getEmail());
        user.setFirstName(userCreateDTO.getFirstName());
        user.setLastName(userCreateDTO.getLastName());
        return user;
    }

    public UserCreateDTO mapUserEntityToUserDTO(User user){
        return UserCreateDTO.builder().age(user.getAge()).email(user.getEmail())
                .username(user.getUserName()).firstName(user.getFirstName())
                .lastName(user.getLastName()).password(user.getPassword()).build();
    }

    public UserSearchDTO mapUserEntityToUserSearchDTO(User user){
        return UserSearchDTO.builder().id(user.getId()).age(user.getAge()).email(user.getEmail())
                .username(user.getUserName()).firstName(user.getFirstName())
                .lastName(user.getLastName()).password(user.getPassword()).build();
    }
}