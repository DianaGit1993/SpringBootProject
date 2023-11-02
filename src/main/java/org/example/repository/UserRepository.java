package org.example.repository;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository
{
    User user1=new User("Alex","John","alexJohn","email","password",23);
    User user2=new User("Ana","Maria","ana","email","parola",21);
    User user3=new User("Crina","Denisa","username","email","parola",23);
    public List<User> fiindUsersByFirstName(String firstName)
    {
        //run sql query
        return List.of(user1,user2,user3);
    }

}
