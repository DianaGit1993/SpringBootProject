package org.example.repository;


import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private User user1=new User("Alex","Doe");
    private User user2=new User("Mike","Tyson");
    private User user3=new User("Erika","Smith");


    public List<User> findUsersByFirstName(String firstName){
        //run sql query to get user by username
        return List.of(user1,user2,user3)
                .stream()
                .filter(user -> user.getFirstName().equals(firstName))
                .toList();
    }

}
