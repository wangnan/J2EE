package com.wangnan.backend.dcn.request;

import java.util.ArrayList;
import java.util.List;


public class WFDcn {

	String id;
	String op;
	String subject;
	String to;
	String from;
	boolean read;
	boolean priority;
	String body;
	String received;
	List<WFDCNReq> data;
	
	public String getReceived() {
		return received;
	}
	public void setReceived(String received) {
		this.received = received;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public boolean getRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public WFDCNReq getData() {
		return null;
	}
	public void setData(WFDCNReq data) {
		this.data = new ArrayList<WFDCNReq>();
		this.data.add(data);
	}
	
	// getter and setter
	

}
