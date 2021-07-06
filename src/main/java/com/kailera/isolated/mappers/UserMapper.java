package com.kailera.isolated.mappers;

import com.kailera.isolated.DTOs.user.UserDTO;
import com.kailera.isolated.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "email", source = "email")
    User toModel (UserDTO userDTO);

    UserDTO toDTO (User user);

}
