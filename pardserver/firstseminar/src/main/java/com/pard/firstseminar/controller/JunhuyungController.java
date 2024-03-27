package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/junhyung")
public class JunhuyungController {
    public String requestInfo(
            @RequestParam(defaultValue = "친구이름") String name,
            @RequestParam(defaultValue = "친구나이") Integer age,
            @RequestParam(defaultValue = "친구전공") String major,
            @RequestParam(defaultValue = "친구취미") String hobby
    ){
        return "이준형/26/컴공/서핑 <<<<<< 여기부터 짝꿍꺼 <<<<<< " + name + "/" + age + "/" + major + "/" + hobby;
    }
}
