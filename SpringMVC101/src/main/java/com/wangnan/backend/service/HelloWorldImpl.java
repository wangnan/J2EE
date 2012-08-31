package com.wangnan.backend.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.wangnan.backend.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}