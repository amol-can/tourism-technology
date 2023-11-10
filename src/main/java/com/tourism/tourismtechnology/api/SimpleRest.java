package com.tourism.tourismtechnology.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simple")
public class SimpleRest {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
