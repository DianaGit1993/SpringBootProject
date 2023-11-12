package org.example.repository;

//import org.example.model.dtos.UserDTO;
//import org.example.model.entities.User;
import org.example.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.LongStream;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Stream;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



//    private UserDTO userDTO1 = new UserDTO("alex", "Jhon", "user", "email@alex.ro", "hdfh", 50);
//    private UserDTO userDTO2 = new UserDTO("Mike", "Tyson", "", "email@mike.ro", "gfd", 25);
//    private UserDTO userDTO3 = new UserDTO("Erika", "Smith", "", "email@erika.ro", "gfdg", 23);
//
//    private List<User> userEntities = new ArrayList<>();
//
//    public List<UserDTO> findUsersByFirstName (String firstName) {
//        //run sql query to get user by username from DB SELECT
//
//        return Stream.of(userDTO1, userDTO2, userDTO3)
//            .filter(userDTO -> userDTO.getFirstName().equals(firstName))
//            .toList();
//    }
//
//    public User createUser(User usertoSavetoDB) {
//        userEntities.add(usertoSavetoDB);
//        return usertoSavetoDB;
//    }
}
