package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BugController {
    @RequestMapping("/")
    public String showBug() {
        return "index";
    }
}
