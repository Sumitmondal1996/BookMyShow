package com.scaler.bookmyshow.controller;

import com.scaler.bookmyshow.dtos.ResponseStatus;
import com.scaler.bookmyshow.dtos.UserRequestDto;
import com.scaler.bookmyshow.dtos.UserResponsedto;
import com.scaler.bookmyshow.exception.UserNotFoundException;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signup")
    public ResponseStatus login(@RequestBody UserRequestDto userRequestDto) throws UserNotFoundException {
        return userService.login(
                userRequestDto.getEmail(),
                userRequestDto.getPassword()
        );


    }

    public UserResponsedto signup(@RequestBody UserRequestDto userRequestDto) {
        User user = userService.signup(
                userRequestDto.getEmail(),
                userRequestDto.getName(),
                userRequestDto.getPassword()
        );
        UserResponsedto userResponseDto = new UserResponsedto();
        userResponseDto.setUser(user);
        return userResponseDto;
    }



}
