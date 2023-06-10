package com.example.assemble.service;

import com.example.assemble.dto.UserDto;
import com.example.assemble.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User saveUser(UserDto userDto);
}
