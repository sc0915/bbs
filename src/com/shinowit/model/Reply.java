package com.shinowit.model;

import java.sql.Timestamp;

public class Reply {
		
	private int replyid;
	
	private int userid;
	
	private int reportid;
	
	private String reply;
	
	private Timestamp replyday;
	
	private UserInfo userinfo;
	
	public int getReplyid() {
		return replyid;
	}

	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getReportid() {
		return reportid;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Timestamp getReplyday() {
		return replyday;
	}

	public void setReplyday(Timestamp replyday) {
		this.replyday = replyday;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

}
