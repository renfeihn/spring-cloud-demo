package com.renfei.consumer;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("demo-producer")
public interface TestService {

    @RequestMapping(method = RequestMethod.GET, value = "/testProducer/hello")
    String hello(@RequestParam("name") String name);
}
