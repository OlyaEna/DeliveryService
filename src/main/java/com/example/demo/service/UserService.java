package com.example.demo.service;


import com.example.demo.dto.UserDto;
import com.example.demo.model.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

    UserDto getById(Long id);




}
