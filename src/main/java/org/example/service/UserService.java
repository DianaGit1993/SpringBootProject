package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private final UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public List<User> fiindUsersByFirstName(String firstName)
    {
        //validate,transform...
        return userRepository.fiindUsersByFirstName(firstName)
                .stream()
                .filter(user->user.getFirstName().equals(firstName)).toList();
    }

}
