package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> findUsersByFirstName(String firstName){
        // validate, transform...
        return userRepository.findUsersByFirstName(firstName);
    }

}
