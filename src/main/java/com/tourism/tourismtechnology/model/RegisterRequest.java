package com.tourism.tourismtechnology.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String username;
    private String password;
    private String role;
}
