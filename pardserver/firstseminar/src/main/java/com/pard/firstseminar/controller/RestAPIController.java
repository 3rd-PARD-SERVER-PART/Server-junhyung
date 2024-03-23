package com.pard.firstseminar.controller;


import org.springframework.web.bind.annotation.*;

// class 명과 annotation 명이 같으면 스프링이 인식을 못한다.
//
@RestController
@RequestMapping("/user") // user 로 들어오면 밑의 컨트롤러를 사용하게 된다는 뜻.
public class RestAPIController {
    @GetMapping("/{userId}")
    public String hi(@PathVariable Integer userId) {
        return "Get으로 온 컨트롤러" + userId;
    }
    @GetMapping
    public String userAll(){
        return "Get: userAll";
    }

    @PostMapping
    public String userCreate() {
        return "Post : userCreate";
    }

    @PutMapping
    public String userUpdate(){
        return "Put: userUpdate()";
    }

    @PatchMapping
    public String userUpdateByPatch(){
        return "Patch: userUpdateByPatch()";
    }

    @DeleteMapping
    public String userDelete(){
        return "Delete: userDelete()";
    }
}
