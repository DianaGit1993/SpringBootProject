package org.example.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class User {
    private String firstName;
    private String lastName;
    private String username;

    @NotBlank(message = "Emailul nu poate fi null.")
    private String email;
    private int age;
    private String password;
}
