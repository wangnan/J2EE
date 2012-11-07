package com.wangnan.backend.dcn.request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DCNGenerator {
	public String msgid = null; // Message ID (id) of the Mobile Workflow ¨C used
								// for correlation (a :delete for a previously
								// submitted request with :upsert is possible)
	public String op = null;
	public String subject = "";		// will be show on the list
	public String to = null;		// sup user name
	public String from = "SysAdmin";
	public boolean read = false;
	public boolean priority = false; //
	public String body = "";
	String received = null;

	public void setReceived(Date t) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ"); // 2009-03-29T10:07:45+05:00
		received = formatter.format(t);

	}

	public String login = null;
	public String pwd = null;
	public String ip = "localhost";
	public String port = "8000";
	// public String cmd = "dcn"; // dcn or wf
	public String domain = "default";
	public String path = "/dcn/HttpAuthDCNServlet?"; // /dcn/HttpAuthDCNServlet?
														// or /dcn/DCNServlet?
	public String protocol = "HTTP";
	public String security = "admin";
	public String pkg = null;

	public boolean isWF = false;

	public List<Object> messages = null;
	
	public void setMustParamForDCN(String login, String password, String packageName) {
		this.login = login;
		this.pwd = password;
		this.pkg = packageName;
		this.isWF = false;
	}
	
	public void setMustParamForWFDCN (String login, String password, String packageName, String msgid, String op, String to) {
		this.login = login;
		this.pwd = password;
		this.pkg = packageName;
		this.op = op;
		this.msgid = msgid;
		this.to = to;
		this.isWF = true;
		
	}
	

	public void appenMsg(String mbo, String op, List<Object> data,
			boolean clearList) throws Exception {
		if (mbo.equals("") || op.equals("")) {
			throw new Exception("Please set the mbo or op parameter");
		}

		if (clearList || messages == null) {
			messages = new ArrayList<Object>();
		}

		int len = data.size();
		int base = messages.size();

		for (int i = 0; i < len; i++) {
			Message m = new Message();
			m.setCols(data.get(i));
			m.setId((i + base++) + "");
			m.setMbo(mbo);
			m.setOp(op);
			messages.add(m);
		}
	}

	protected DCNRequest genDCNRequest() throws Exception {
		if (this.pkg.equals("")) {
			throw new Exception("Please set the package name.");
		}

		DCNRequest df = new DCNRequest();
		df.setPkg(this.pkg);
		df.setMessages(this.messages);

		return df;
	}

	protected WFDcn genWFRequest() throws Exception {
		if(this.to == null || this.msgid == null || this.op == null) {
			throw new Exception("Please set the value for the \"to\", \"op\", or \"msgid\" parameter.");
		}
		WFDCNReq r = new WFDCNReq();
		r.setPkg(this.pkg);
		r.setMessages(this.messages);
		r.setId(this.msgid);

		WFDcn mf = new WFDcn();
		mf.setBody(this.body);
		mf.setData(r);
		mf.setFrom(this.from);
		mf.setId(this.msgid);
		mf.setOp(this.op);
		mf.setPriority(this.priority);
		mf.setRead(this.read);
		mf.setSubject(this.subject);
		mf.setTo(this.to);

		if (this.received == null) {
			this.setReceived(new Date(System.currentTimeMillis()));
		}

		mf.setReceived(this.received);
		return mf;

	}

	public String generateReq() throws Exception {
		Object req = null;
		if (isWF) {
			req = genWFRequest();
		} else {
			req = genDCNRequest();
		}

		ObjectMapper mapper = new ObjectMapper();

		try {

			// convert user object to json string, and save to a file

			// display to console
			return mapper.writeValueAsString(req);

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		}
		return null;
	}

	public void senRequest(String dcn_request) throws Exception {
		if(login == null || pwd == null || pkg == null) {
			throw new Exception("Please set the value for the logn, pwd, pkg parameter");
		}
		String cmd = "";
		if (this.isWF) {
			cmd = "wf";
		} else {
			cmd = "dcn";
		}
		try {
			URL url = null;

			url = new URL(this.protocol, this.ip, Integer.parseInt(this.port),
					this.path + "cmd=" + cmd + "&security=" + this.security
							+ "&domain=" + this.domain + "&package=" + this.pkg);
			
			System.out.println("The request url is:" + url.toString());

			HttpURLConnection con = null;

			con = (HttpURLConnection) url.openConnection();

			con.setDoOutput(true);
			con.setRequestMethod("POST");

			Authenticator.setDefault(new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(login, pwd.toCharArray());
				}
			});

			StringBuffer sb = new StringBuffer();
			sb.append(dcn_request);
			OutputStream os = con.getOutputStream();
			os.write(sb.toString().getBytes());
			os.flush();
			os.close();

			StringBuffer xmlResponse = new StringBuffer();

			int returnCode = con.getResponseCode();
			if (returnCode != 200) {
				String rspErrorMsg = "Error getting response from the server (error code "
						+ returnCode + ")" + con.getResponseMessage();
				System.out.println(rspErrorMsg);

			} else {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream(), "UTF-8"));
				String line;
				while ((line = in.readLine()) != null) {
					xmlResponse.append(line).append("\n");
				}
				System.out.println("xmlResponse: " + xmlResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
