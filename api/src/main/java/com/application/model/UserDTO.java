package com.application.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
    @NotEmpty(message = "Username should not be empty")
    private String username;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    @NotEmpty(message = "Firstname should not be empty")
    private String firstName;
    @NotEmpty(message = "Lastname should not be empty")
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
}