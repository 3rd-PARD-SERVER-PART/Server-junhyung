package com.pard.secondsemiar.user.controller;

import com.pard.secondsemiar.user.dto.UserDto;
import com.pard.secondsemiar.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/find/{studentId}")
    public UserDto findById(@PathVariable Integer studentId){
        return userService.findById(studentId);
    }

    @PatchMapping("/{studentId}")
    public void update(@PathVariable Integer studentId, @RequestBody UserDto userDto){
        userService.update(studentId, userDto);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable Integer studentId){
        userService.delete(studentId);
    }

}
