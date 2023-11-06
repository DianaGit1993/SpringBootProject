package org.example.repository;

import org.example.model.dtos.UserDTO;
import org.example.model.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository
{
    UserDTO user1=new UserDTO("Alex","John","alexJohn","email","password",23);
    UserDTO user2=new UserDTO("Ana","Maria","ana","email","parola",21);
    UserDTO user3=new UserDTO("Crina","Denisa","username","email","parola",23);
    private List<UserEntity> userEntities=new ArrayList<>() ;

    public List<UserDTO> fiindUsersByFirstName(String firstName)
    {
        //run sql query
        return List.of(user1,user2,user3);
    }
    public UserEntity createUser(UserEntity userToSaveIdOB)
    {
        userEntities.add(userToSaveIdOB);
        return userToSaveIdOB;
    }

}
