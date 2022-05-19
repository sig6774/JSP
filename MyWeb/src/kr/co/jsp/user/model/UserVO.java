package kr.co.jsp.user.model;

public class UserVO {
	/*
	  CREATE TABLE my_user ( user_id VARCHAR2(30) PRIMARY KEY, user_pw VARCHAR2(30)
	  NOT NULL, user_name VARCHAR2(2) NOT NULL, user_email VARCHAR2(100),
	  user_address VARCHAR2(100) );
	  
	 */
	
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private String user_address;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public UserVO(String user_id, String user_pw, String user_name, String user_email, String user_address) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_address = user_address;
	}
	

}
