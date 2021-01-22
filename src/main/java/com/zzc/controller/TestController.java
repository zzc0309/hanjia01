package com.zzc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
    @GetMapping("/test01")
    public String test(){
        return "hello spring boot";
    }
}
