package kr.co.pr.user.model;

public class UserVO {

	/*
	 * CREATE TABLE PR_USER ( user_id varchar2(30) primary key, 
	 * user_pw varchar2(30) not null, name varchar2(10) not null, 
	 * telephone Number, email VARCHAR2(30), address VARCHAR2(100));
	 */
	
	private String userId;
	private String userPw;
	private String name;
	private String Number;
	private String email;
	private String address;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserVO(String userId, String userPw, String name, String number, String email, String address) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
		this.Number = number;
		this.email = email;
		this.address = address;
	}
	
	
}
