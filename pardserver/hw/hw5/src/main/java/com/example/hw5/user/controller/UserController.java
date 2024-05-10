package com.example.hw5.user.controller;

import com.example.hw5.user.dto.UserDTO;
import com.example.hw5.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public String createUser(@RequestBody UserDTO.Create dto) {
        userService.createUser(dto);
        return "User 추가됨";
    }

    @GetMapping("/user")
    public List<UserDTO.Read> readAll() {
        return userService.readAll();
    }


    @PostMapping("/loan")
    public String loan(@RequestBody UserDTO.Loan dto) {
        return userService.borrow(dto);
    }


    @PostMapping("/return")
    public String returnBook(@RequestBody UserDTO.Loan dto) {
        return userService.returnBook(dto);
    }

    @GetMapping("/user/{userId}")
    public UserDTO.Read readById(@PathVariable Long userId) {
        return userService.readById(userId);
    }

}
