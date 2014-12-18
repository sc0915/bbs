package com.shinowit.actions;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionSupport;
import com.shinowit.dao.ReplyDao;
import com.shinowit.dao.ReportDao;
import com.shinowit.model.Reply;
import com.shinowit.model.Report;

public class ReportListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ReportDao rd;
	
	@Resource
	private ReplyDao rdao;
	
	private List<Reply> replylist;
	
	private List<Report> list;
	
	private int sumpage;
	
	private int pageid=1;
	
	public String reportlist(){
	   
		int i=rd.querysum();
		sumpage=i/4;
		if(i%3>0){
			sumpage++;
		}
		
		list=rd.queryreport(pageid,4);
		
		for(Report r:list){
			replylist=rdao.queryreply(r.getReportid()); 
			r.setRelist(replylist);
		}
		return SUCCESS;
	}

	public List<Report> getList() {
		return list;
	}

	public void setList(List<Report> list) {
		this.list = list;
	}

	public List<Reply> getReplylist() {
		return replylist;
	}

	public void setReplylist(List<Reply> replylist) {
		this.replylist = replylist;
	}

	public int getSumpage() {
		return sumpage;
	}

	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}

	public int getPageid() {
		return pageid;
	}

	public void setPageid(int pageid) {
		this.pageid = pageid;
	}
}
