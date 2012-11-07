package com.wangnan.backend.dcn.samples;

import java.util.ArrayList;

import com.wangnan.backend.dcn.POJO.CustomerBO;
import com.wangnan.backend.dcn.request.DCNGenerator;

public class DcnClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Object> ol = new ArrayList<Object>();
		for (int i = 0; i < 1; i++) {
			CustomerBO c = new CustomerBO();
			c.setFname("fname");
			c.setLname("lname");
			c.setAddress("Beijing china");
			c.setCity("Beijing");
			c.setCompany_name("My company");
			c.setPhone("186020303");
			c.setState("BJ");
			c.setZip("100060");
			c.setId(1000 + i);
			ol.add(c);
		}
		
		DCNGenerator g = new DCNGenerator();
		try {
			g.appenMsg("Customer", ":upsert", ol, true);
			g.setMustParamForDCN("supAdmin", "s3pAdmin", "SUP101:1.0");
			g.ip = "10.80.1.18";
			String req = g.generateReq();
			System.out.println(req);
			
			g.setMustParamForWFDCN("supAdmin", "s3pAdmin", "SUP101:1.0", "fjdslfjsd-fdsfsdf", ":upsert", "supAdmin");
			g.ip = "10.80.1.18";
			req = g.generateReq();
			System.out.println(req);
			
			g.senRequest(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
