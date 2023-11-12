package org.example.service;

import org.example.model.dtos.UserDTO;
import org.example.model.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapUserDTOtoUserEntity (UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(user.getPassword());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(userDTO.getLastName());
        return user;
//        return new User(
//            userDTO.getFirstName(),
//            userDTO.getLastName(),
//            userDTO.getUserName(),
//            userDTO.getEmail(),
//            userDTO.getPassword(),
//            userDTO.getAge()
//        );
    }

    public UserDTO mapUserEntitytoUserDTO (User user) {
       return UserDTO.builder()
            .age(user.getAge())
            .email(user.getEmail())
            .userName(user.getUserName())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .password(user.getPassword())
            .build();
    }

}
