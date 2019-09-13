package com.renfei.producer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testProducer")
public class ProducerTestController {


    @RequestMapping("hello")
    public String hello(String name) {

        System.out.println("producer 收到的数据：" + name);
        return "hello " + name;
    }
}
