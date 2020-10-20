package edu.project.rent.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")

    String sayHello(){
        String string = "<h1> hello from controller</h1>";
        return string;
    }

}
