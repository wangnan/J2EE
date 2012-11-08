package com.wangnan.backend.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.wangnan.backend.util.ApplicationContextProvider;

public class TaskDAO  implements ApplicationContextAware{

	ApplicationContext ctxt = null;
	public void addTask(String tname,String tcontent) {
		ctxt = ApplicationContextProvider.getApplicationContext();
        SessionFactory sf = (SessionFactory) ctxt.getBean("sessionFactory");
        Session session=sf.openSession();
        TaskStore t = new TaskStore();
        t.setPriority(1);
        t.setTcontent("some task");
        t.setTimestamp(new Date());
        t.setTname("name");
        session.save(t);
        session.close();
	}
	
	public void removeTask() {
		
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		this.ctxt = arg0;
	}
}
