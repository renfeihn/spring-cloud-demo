package com.renfei.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testConsumer")
public class ConsumerTestController {


    @Autowired
    private TestService testService;


    @RequestMapping("hello")
    public String hello(String name){
        return testService.hello(name);
    }



}
