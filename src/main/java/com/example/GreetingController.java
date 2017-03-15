package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
    private static final String template = "Hello World!";

    @RequestMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(String.format(template));
    }
}
