package com.shinowit.actions;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.shinowit.dao.ReportDao;
import com.shinowit.model.Report;

public class ReportAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ReportDao rd;
	
	private Report re;
	
	
	public String execute(){
		return SUCCESS;
	}
	
	public String insertreport(){
		if((re.getReport()==null)||(re.getReport().trim().length()==0)){
			this.addFieldError("re.report","发表内容不能为空！");
		}
		if(this.hasErrors()==true){
			return INPUT;
		}
		boolean result=rd.insertreport(re);
		if(result==true){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
	public String deletereport(){
		boolean result1 = rd.deletereport(re.getReportid());
		if(result1==true){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}

	public Report getRe() {
		return re;
	}

	public void setRe(Report re) {
		this.re = re;
	}
}
