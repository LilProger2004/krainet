package com.krainet.timetrack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo/")
@RequiredArgsConstructor
public class DemoController {


        @GetMapping("/test")
        public String gtt() {
            return "rfrgtrg";
        }
    }

