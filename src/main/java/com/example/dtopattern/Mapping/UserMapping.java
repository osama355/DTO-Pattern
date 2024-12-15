package com.example.dtopattern.Mapping;

import com.example.dtopattern.dto.UserDto;
import com.example.dtopattern.entity.User;

public class UserMapping {
    public static UserDto toDto(User user){
        return new UserDto(
                user.getUserId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber()
        );
    }

    public static  User toJpa(UserDto userDto){
        return new User(
                userDto.getUserId(),
                userDto.getEmail(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getPhoneNumber()
        );
    }
}
