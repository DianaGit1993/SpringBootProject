package org.example.repository;

import org.example.model.User;
import org.example.model.dtos.UserDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository

// UserRepositoy devine interfata
public interface UserRepository extends JpaRepository<org.example.model.entities.User, Long> {
    @Query("")
    List<User> findUSerByFirstName(String firstName);
// curs 24.10
//public class UserRepository{
//    // pt test
//    // pe viitor se va lucra cu baza de date pe tipul acesta de structura
////    private User user1 = new User("alex", "Jhon");
////    private User user2 = new User("Mike", "Tyson");
////    private User user3 = new User("Erica", "Smith");
//    public List<User> findUsersByFirstName(String firstName){
//        // run sql query to get user by username from DB
//        return Stream.of(user1, user2, user3)
//                .filter(user -> user.getFirstName().equals(firstName)).toList();
//    }
//
//    // curs 31.10 -> au fost adaugate proprietati noi obiectului User
//    private User user1 = new User("alex","Jhon", "last", "email", 23, "password");
//    private User user2 = new User("Mike","Tyson", "last", "email@aswd", 30, "pass1234");
//    private User user3 = new User("Erica","Smith", "last", "email@test.fom", 40, "wewe");

//public class UserRepository {
//public interface UserRepository extends JpaRepository<User, Long> {
//    private User user1 = new User("alex","Jhon", );
//    private User user2 = new User("Mike","Tyson");
//    private User user3 = new User("Erica","Smith");

//    private User user1 = new User("alex","Jhon", "last", "email", 23, "password");
//    private User user2 = new User("Mike","Tyson", "last", "email@aswd", 30, "pass1234");
//    private User user3 = new User("Erica","Smith", "last", "email@test.fom", 40, "wewe");
//    public List<User> findUsersByFirstName(String firstName){
//        //run sql query to get user by username
//        return Stream.of(user1, user2, user3).filter(user -> user.getFirstName()
//                .equals(firstName)).toList();
//    }

//    private User userDTO1 = new User("alex","Jhon", "last", "email", 23, "password");
//    private User userDTO2 = new User("Mike","Tyson", "last", "email@aswd", 30, "pass1234");
//    private User userDTO3 = new User("Erica","Smith", "last", "email@test.fom", 40, "wewe");
//
//    private List<UserEntity> userEntities = new ArrayList<>();
//
//    public List<UserDTO> findUsersByFirstName(String firstName){
//        //run sql query to get user by username
//        return Stream.of(userDTO1, userDTO2, userDTO3).filter(user -> user.getFirstName()
//                .equals(firstName)).toList();
//    }
//
//    public UserEntity createUser(UserEntity userToSaveInDB){
//        userEntities.add(userToSaveInDB);
//        return userToSaveInDB;
//    }
//


//}

}