package com.wangnan.backend.dcn.request;

import java.util.List;

public class DCNRequest {

	String pkg;
	List<Object> messages;
	public String getPkg() {
		return pkg;
	}
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	public List<Object> getMessages() {
		return messages;
	}
	public void setMessages(List<Object> messages) {
		this.messages = messages;
	}

}
