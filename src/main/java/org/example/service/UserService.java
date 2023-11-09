package org.example.service;

import org.example.model.dtos.UserCreateDTO;
import org.example.model.entities.UserEntity;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper; // custom mapper
    private final ModelMapper modelMapper;

    @Autowired
    UserService(UserRepository userRepository, UserMapper userMapper,
                ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
    }

    public List<UserCreateDTO> findUsersByFirstName(String firstName) {
        // validate, transform...
        return userRepository.findUsersByFirstName(firstName);
    }

    public UserCreateDTO createUser(UserCreateDTO userToCreateDTO) {
        // translate from UserDTO -> UserEntity
       UserEntity userEntity = userMapper.mapUserDTOtoUserEntity(userToCreateDTO);
       UserEntity createdUserEntity = userRepository.createUser(userEntity);
       return userMapper.mapUserEntityToUserDTO(createdUserEntity);// translate from UserEntity -> UserDTO
    }

    public UserCreateDTO updateUser(UserCreateDTO userCreateDTO){

        UserEntity userEntity = modelMapper.map(userCreateDTO, UserEntity.class);
        // userRepository...
        return modelMapper.map(userEntity, UserCreateDTO.class);

    }

}
