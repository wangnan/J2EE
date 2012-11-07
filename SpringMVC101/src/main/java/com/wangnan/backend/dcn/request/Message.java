package com.wangnan.backend.dcn.request;


public class Message {

	String id;
	String mbo;
	String op;
	Object cols;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMbo() {
		return mbo;
	}
	public void setMbo(String mbo) {
		this.mbo = mbo;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public Object getCols() {
		return cols;
	}
	public void setCols(Object cols) {
		this.cols = cols;
	}
}
