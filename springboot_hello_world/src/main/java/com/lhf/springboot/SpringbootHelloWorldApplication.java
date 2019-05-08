package com.lhf.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SpringbootHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloWorldApplication.class, args);
    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String sayHi(){
        return "Springboot Hello World";
    }

}
