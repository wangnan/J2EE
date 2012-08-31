package com.wangnan.backend.service;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebService(endpointInterface = "com.wangnan.backend.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	@Resource
	private WebServiceContext context;
    public String sayHi(String text) {
        System.out.println("sayHi called");
        
        MessageContext ctx = context.getMessageContext();
        HttpServletRequest request = (HttpServletRequest) 
            ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse) 
            ctx.get(AbstractHTTPDestination.HTTP_RESPONSE);
        
        ApplicationContext beanFactory =
        	    WebApplicationContextUtils
        	        .getRequiredWebApplicationContext(request.getSession().getServletContext());
        
        SessionFactory sf = (SessionFactory) beanFactory.getBean("sessionFactory");
        Session session=sf.openSession();
        session.close();
        return "Hello " + text;
    }
}