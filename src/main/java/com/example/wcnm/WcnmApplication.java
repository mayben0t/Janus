package com.example.wcnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class WcnmApplication {

    public static void main(String[] args) {
        SpringApplication.run(WcnmApplication.class, args);
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
