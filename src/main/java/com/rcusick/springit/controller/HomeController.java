package com.rcusick.springit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RCusick
 */
@RestController
public class HomeController {
    
    @RequestMapping("/")
    public String home(){
        return "Hello, Spring Boot 2";
    }
    
}
