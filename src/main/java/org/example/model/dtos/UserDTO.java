package org.example.model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class UserDTO
{

    private String firstName;
    private String lastName;
    private String username;
    @NotBlank(message = "Email can not be null")
    private String email;
    private String password;
    private int age;
   public UserDTO(String firstName, String lastName, String username, String email, String password, int age)
    {
        this.age=age;
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.email=email;
    }
    public UserDTO(){}



}
