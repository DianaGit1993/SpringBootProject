package org.example.service;

import org.example.model.dtos.UserDTO;
import org.example.model.entities.UserEntity;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> findUsersByFirstName(String firstName) {
        // validate, transform...
        return userRepository.findUsersByFirstName(firstName);
    }

    public UserDTO createUser(UserDTO userToCreateDTO) {
        // translate from UserDTO -> UserEntity

        UserEntity userEntity = userMapper.mapUserDTOtoUserEntity(userToCreateDTO);

       UserEntity createdUserEntity = userRepository.createUser(userEntity);

       return userMapper.mapUserEntityToUserDTO(createdUserEntity);
    }

}
