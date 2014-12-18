package com.shinowit.model;

import java.sql.Timestamp;

public class UserInfo {
	
	private int userid;
	
	private String userName;
	
	private String userPass;
	
	private String passDefend;
	
	private String answer;
	
	private Timestamp birthday;
	
	private int sexid;
	
	private String name;
	
	private String email;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getPassDefend() {
		return passDefend;
	}

	public void setPassDefend(String passDefend) {
		this.passDefend = passDefend;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public int getSexid() {
		return sexid;
	}

	public void setSexid(int sexid) {
		this.sexid = sexid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
