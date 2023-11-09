package org.example.repository;

import org.example.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

     User findUserById(Long id);

     List<User> findUserByFirstName(String firstName);

     int deleteUserById(Long id);

//     using native query
     @Query(value = "SELECT * FROM users WHERE age > 17", nativeQuery = true)
     List<User> findUsersThatAreAdults();
//
//     //using jpql query
//     @Query(value = "SELECT u FROM user u WHERE u.age > 17")
//     List<User> findUsersThatAreAdults();
//


}
