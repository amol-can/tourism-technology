package com.tourism.tourismtechnology.mapper;

import com.tourism.tourismtechnology.entity.User;
import com.tourism.tourismtechnology.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "user.role", target = "userRole")
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}