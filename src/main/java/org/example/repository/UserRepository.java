package org.example.repository;

import org.example.model.dtos.UserDTO;
import org.example.model.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class UserRepository {

   private UserDTO userDTO1 = new UserDTO("alex","Jhon","last","email",23,"password");
   private UserDTO userDTO2 = new UserDTO("Mike","Tyson","last","email@asdwed", 30, "pass1234");
   private UserDTO userDTO3 = new UserDTO("Erica","Smith","Jhon","email@test.fom",40, "wefwefwef");

   private List<UserEntity> userEntities = new ArrayList<>();
    public List<UserDTO> findUsersByFirstName(String firstName){
        //run sql query to get user by username
        return Stream.of(userDTO1, userDTO2, userDTO3).filter(userDTO -> userDTO.getFirstName()
                .equals(firstName)).toList();
    }

    public UserEntity createUser(UserEntity userToSaveIdDB){
        userEntities.add(userToSaveIdDB);
        return userToSaveIdDB;
    }

}
