package com.example.hw5.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @GetMapping("/loginForm")
    public String login(){
        return "loginForm";
    }
}
