package org.example.service;

import org.example.model.dtos.UserDTO;
import org.example.model.entities.User;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper; //custom mapper
    private final ModelMapper modelMapper;

    @Autowired
    UserService(UserRepository userRepository, UserMapper userMapper, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
    }

//    public List<UserDTO> findUsersByFirstName (String firstName) {
//       // validate, transform...
//       return userRepository.findUsersByFirstName(firstName);
//    }

    public UserDTO createUser(UserDTO userToCreateDTO) {
        // translate from UserDTO to User

//        User user = userMapper.mapUserDTOtoUserEntity(userToCreateDTO);
//        User createdUser = userRepository.createUser(user);
//        return userMapper.mapUserEntitytoUserDTO(createdUser);

        User user = userMapper.mapUserDTOtoUserEntity(userToCreateDTO);
        User createdUser = userRepository.save(user);
        return userMapper.mapUserEntitytoUserDTO(createdUser);

    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        // userRepository ...
        return modelMapper.map(user, UserDTO.class);
    }
}
