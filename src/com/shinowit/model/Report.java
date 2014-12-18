package com.shinowit.model;

import java.sql.Timestamp;
import java.util.List;

public class Report {

	
	private int reportid;
	
	private int userid;
	
	private Timestamp reportday;
	
	private String report;
	
	private UserInfo userinfo;
	
	private Reply reply;
	
	private List<Reply> relist;
	
	public int getReportid() {
		return reportid;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Timestamp getReportday() {
		return reportday;
	}

	public void setReportday(Timestamp reportday) {
		this.reportday = reportday;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public List<Reply> getRelist() {
		return relist;
	}

	public void setRelist(List<Reply> relist) {
		this.relist = relist;
	}

}
