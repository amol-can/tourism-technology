package com.tourism.tourismtechnology.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String userRole;

}