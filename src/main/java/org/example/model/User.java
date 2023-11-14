package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    // curs 24.10
    private String firstName;
    private String lastName;

    // adaugate curs 31.10
    private String username;
//    @NotBlank(message = "Email can not be empty")
//   // @NotNull
//   // @NotEmpty
    private String email;
    private int age;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)   // pentru parole, date sensibile
    private String password;
}
