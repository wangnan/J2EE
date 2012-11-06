package com.wangnan.jaxws;

import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "com.wangnan.jaxws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString() {
		return "Hello World JAX-WS";
	}
}