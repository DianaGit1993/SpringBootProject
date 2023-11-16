package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.model.entities.Address;
import org.example.model.entities.User;
import org.example.repository.AddressRepository;
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
    private final AddressRepository addressRepository;
    private final UserMapper userMapper; // custom mapper
    private final ModelMapper modelMapper;

    @Autowired
    UserService(UserRepository userRepository, UserMapper userMapper,
                ModelMapper modelMapper, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

//    public List<UserCreateDTO> findUsersByFirstName(String firstName) {
//        // validate, transform...
//        return userRepository.findUsersByFirstName(firstName);
//    }

    @Transactional
    public UserSearchDTO createUser(UserCreateDTO userToCreateDTO) {
        // translate from UserDTO -> UserEntity
        User user = userMapper.mapUserDTOtoUserEntity(userToCreateDTO);
        User createdUser = userRepository.save(user);//salvam userul in db => user entity\
        return userMapper.mapUserEntityToUserSearchDTO(createdUser);// translate from UserEntity -> UserDTO
    }

    public List<UserSearchDTO> findAllUsers() {
        List<User> userEntities = userRepository.findAll();
        return userEntities.stream().map(userMapper::mapUserEntityToUserSearchDTO).collect(Collectors.toList());
    }

    public UserCreateDTO updateUser(UserCreateDTO userCreateDTO) {

        User user = modelMapper.map(userCreateDTO, User.class);
        // userRepository...
        return modelMapper.map(user, UserCreateDTO.class);

    }

}
