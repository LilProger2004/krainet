package com.krainet.timetrack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "/hellowrd",produces = "application/json")
    public String example() {
        return "Hello, world!";
    }
}
