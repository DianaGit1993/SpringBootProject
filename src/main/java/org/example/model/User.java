package org.example.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class User
{
    private String firstName;
    private String lastName;
    private String username;
    @NotBlank(message = "Email can not be null")
    private String email;
    private String password;
    private int age;
   public User(String firstName,String lastName,String username,String email,String password,int age)
    {
        this.age=age;
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.email=email;
    }
    public User(){}



}
