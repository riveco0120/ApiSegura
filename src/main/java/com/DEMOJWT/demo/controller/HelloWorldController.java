package com.DEMOJWT.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController Controller
 *
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class HelloWorldController {
    @RequestMapping("hello")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + "!!";
    }
}
