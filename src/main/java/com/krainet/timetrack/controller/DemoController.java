package com.krainet.timetrack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    @GetMapping("/test")
    public  String getTest() {
        return "tyu";
    }
}
