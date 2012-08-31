package com.wangnan.backend.service;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	String sayHi(String text);
}