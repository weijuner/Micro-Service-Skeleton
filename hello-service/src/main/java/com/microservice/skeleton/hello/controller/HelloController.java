package com.microservice.skeleton.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr.Yangxiufeng on 2017/12/9.
 * Time:16:44
 * ProjectName:Mirco-Service-Skeleton
 */
@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        return "Hello World : "+ instance.getServiceId();
    }

}
