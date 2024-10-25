package com.krainet.timetrack.controller;

import com.krainet.timetrack.config.security.authjwt.AuthenticationService;
import com.krainet.timetrack.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("main/")
@RequiredArgsConstructor
public class MainController {

    final AuthenticationService authenticationService;

    /**
     *
     * Это контролер для регистрации
     *
     * @param request
     * @return
     */
    @PostMapping("/sign-up")
    public String signUp(@RequestBody String request) {
        return "Use this token to authorization your requests : " + authenticationService.signUp(request);
    }


    /**
     *
     * Это контролер для логинации
     *
     * @param request
     * @return JWT тоекн который нужен для авторизации запросов
     */
    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public  String getAuthUser(@RequestBody String request) {
        return "Use this token to authorization your requests : " + authenticationService.signIn(request);
    }
}
