package com.pard.firstseminar.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {
    @RequestMapping("/path/{name}") // name 부분을 reqeust mapping 으로 받겠다는 뜻
    public String pathV1(@PathVariable("name") String userName) {
        return "PathVariable 연습 name: " + userName;
    }

    @RequestMapping("/pathV2/{name}") // name 부분을 reqeust mapping 으로 받겠다는 뜻
    public String pathV2(@PathVariable("name") String name) {
        return "PathVariable 연습 name: " + name;
    }

    @RequestMapping("/path/{name}/{age}") // name 부분을 reqeust mapping 으로 받겠다는 뜻
    public String pathV3(@PathVariable String name, @PathVariable int age) {
        return "PathVariable 연습 name: " + name + "age: " + age;
    }
}
