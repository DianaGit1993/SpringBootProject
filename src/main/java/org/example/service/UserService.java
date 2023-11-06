package org.example.service;

import org.example.model.dtos.UserDTO;
import org.example.model.entities.UserEntity;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;
    @Autowired
    UserService(UserRepository userRepository,UserMapper userMapper,ModelMapper modelMapper)
    {
        this.userRepository=userRepository;
        this.userMapper=userMapper;
        this.modelMapper=modelMapper;
    }

    public List<UserDTO> fiindUsersByFirstName(String firstName)
    {
        //validate,transform...
        return userRepository.fiindUsersByFirstName(firstName)
                .stream()
                .filter(user->user.getFirstName().equals(firstName)).toList();
    }
    public UserDTO createUser(UserDTO userToCreateDTO)
    {
        //transformam din userDTO in userEntity

       UserEntity userEntity= userMapper.mapUserDTOtoUserEntity(userToCreateDTO);
       UserEntity createdUserEntity=userRepository.createUser(userEntity);

        return userMapper.mapUserEntityToUserDTO(createdUserEntity);
    }

    public UserDTO updateUser(UserDTO userDTO)
    {
        UserEntity userEntity=modelMapper.map(userDTO,UserEntity.class);
        //userRepository,etc
        return modelMapper.map(userEntity,UserDTO.class);
    }


}
