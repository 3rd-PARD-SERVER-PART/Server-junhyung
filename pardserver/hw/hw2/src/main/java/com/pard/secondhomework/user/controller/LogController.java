package com.pard.secondhomework.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j // log 를 찍을 수 있게 해주는 annotation
public class LogController {
    @GetMapping("/log")
    public String log(){
        String name = "SPRING";

        log.info("name : {}", name);
        log.warn("name : {}", name);
        log.error("name : {}", name);
        log.debug("name : {}", name);
        log.trace("name : {}", name);

        return "Hello, " + name;
    }
}
