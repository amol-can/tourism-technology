package com.tourism.tourismtechnology.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterRequest {

    private String username;
    private String password;
    private String fullName;
    private String role;
}
