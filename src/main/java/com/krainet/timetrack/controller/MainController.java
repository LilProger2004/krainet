package com.krainet.timetrack.controller;

import com.krainet.timetrack.config.security.authjwt.AuthenticationService;
import com.krainet.timetrack.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main/")
@RequiredArgsConstructor
public class MainController {

    final EmployeeService service;
    final AuthenticationService authenticationService;


    @PostMapping("/sign-up")
    public String signUp(@RequestBody String request) {
        return "Use this token to authorization your requests : " + authenticationService.signUp(request);
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public  String getAuthUser(@RequestBody String request) {
        return "Use this token to authorization your requests : " + authenticationService.signIn(request);
    }
}
