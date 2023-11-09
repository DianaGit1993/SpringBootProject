package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.model.dtos.UserUpdateDTO;
import org.example.model.entities.User;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<UserSearchDTO> findUsersByFirstName(String firstName) {
        List<User> userEntities = userRepository.findUserByFirstName(firstName);
        return userEntities.stream().map(userMapper::mapUserEntityToUserSearchDTO).collect(Collectors.toList());
    }

    public List<UserSearchDTO> findUsersThatAreAdults() {
        List<User> userEntities = userRepository.findUsersThatAreAdults();
        return userEntities.stream().map(userMapper::mapUserEntityToUserSearchDTO).collect(Collectors.toList());
    }

    public UserCreateDTO createUser(UserCreateDTO userToCreateDTO) {
        // translate from UserDTO -> UserEntity
       User user = userMapper.mapUserDTOtoUserEntity(userToCreateDTO);
       User createdUser = userRepository.save(user);
       return userMapper.mapUserEntityToUserDTO(createdUser);// translate from UserEntity -> UserDTO
    }

    @Transactional
    public boolean deleteUserById(Long id){
       return userRepository.deleteUserById(id)>0;
    }

//
    public UserSearchDTO updateUser(UserUpdateDTO userUpdateDTO){

        User existingUser = userRepository.findUserById(userUpdateDTO.getId());
        // userRepository...
        if(Objects.isNull(existingUser)){
            throw new RuntimeException("UserNotFound");
        }
        User user = modelMapper.map(userUpdateDTO, User.class);
        userRepository.save(user);

        return modelMapper.map(user, UserSearchDTO.class);

    }

}
