package com.nstanogias.taskbackend.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {
    @NotBlank(message = "username is required")
    @Size(max = 40)
    private String username;

    @NotBlank(message = "Password field is required")
    @Size(min = 6, max = 20)
    private String password;
}
