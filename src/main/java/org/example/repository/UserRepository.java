package org.example.repository;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class UserRepository {
    private User user1 = new User("alex", "Jhon");
    private User user2 = new User("Mike", "Tyson");
    private User user3 = new User("Erika", "Smith");
    public List<User> findUsersByFirstName (String firstName) {
        //run sql query to get user by username from DB SELECT

        return Stream.of(user1, user2, user3)
            .filter(user -> user.getFirstName().equals(firstName))
            .toList();
    }
}
