package com.example.dtopattern.service;

import com.example.dtopattern.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(int id);

    List<UserDto> getAllUsers();

    UserDto updateUserById(int id, UserDto userDto);
}
