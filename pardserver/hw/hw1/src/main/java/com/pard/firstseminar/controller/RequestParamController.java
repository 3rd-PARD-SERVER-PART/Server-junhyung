package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {
    @RequestMapping("/basic")
    public String requestParam(
            @RequestParam("name") String hiName,
            @RequestParam("age") int hiAge
            ){
        return "requestParam 연습 name : " + hiName + "Age: " + hiAge;

    }

    @RequestMapping("/v2")
    public String requestParamV2(
            @RequestParam String name,
            @RequestParam int age
    ) {
        return "V2 name : " + name + "age: " + age;
    }

    @RequestMapping("/v3")
    public String requestParamV3(
            String name,
            int age
    ) {
        return "V2 name : " + name + "age: " + age;
    }
    //권장은 하지 않 디버깅할때 힘듦.



    @RequestMapping("/v4")
    public String requestParamV4(
            @RequestParam(required = true) String name,
            @RequestParam(required = false) Integer age // int 등 원시함수는 널 값을 못 넣음. // 그래서 required false 가 안됌
    ) {
        return "V4 name : " + name + "age: " + age;
    }


    @RequestMapping("/v5")
    public String requestParamV5(
            @RequestParam(required = true, defaultValue = "guest") String name, // 파라미터 받아서 다른 걸로 넘겨줄수 있음 다른 variable name으로 등등.
            @RequestParam(required = false, defaultValue = "4") int age
    ) {
        return "V5 name : " + name + "age: " + age;
    }

    @RequestMapping("/junhyung")
    public String requestInfo(
            @RequestParam(defaultValue = "친구이름") String name,
            @RequestParam(defaultValue = "3") Integer age,
            @RequestParam(defaultValue = "친구전공") String major,
            @RequestParam(defaultValue = "친구취미") String hobby
    ){
        return "이준형/26/컴공/서핑 <<<<<< 여기부터 짝꿍꺼 <<<<<< " + name + "/" + age + "/" + major + "/" + hobby;
    }


}
