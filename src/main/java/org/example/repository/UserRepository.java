package org.example.repository;

import org.example.model.dtos.UserCreateDTO;
import org.example.model.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class UserRepository {

   private UserCreateDTO userCreateDTO1 = new UserCreateDTO("alex","Jhon","last","email",23,"password");
   private UserCreateDTO userCreateDTO2 = new UserCreateDTO("Mike","Tyson","last","email@asdwed", 30, "pass1234");
   private UserCreateDTO userCreateDTO3 = new UserCreateDTO("Erica","Smith","Jhon","email@test.fom",40, "wefwefwef");

   private List<UserEntity> userEntities = new ArrayList<>();
    public List<UserCreateDTO> findUsersByFirstName(String firstName){
        //run sql query to get user by username
        return Stream.of(userCreateDTO1, userCreateDTO2, userCreateDTO3).filter(userDTO -> userDTO.getFirstName()
                .equals(firstName)).toList();
    }

    public UserEntity createUser(UserEntity userToSaveIdDB){
        userEntities.add(userToSaveIdDB);
        return userToSaveIdDB;
    }

}
