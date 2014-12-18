package com.shinowit.actions;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.shinowit.dao.ReplyDao;
import com.shinowit.model.Reply;

public class ReplyAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	@Resource
	private ReplyDao rd;
	
	
	private Reply re;
	
	public String execute(){
		return SUCCESS;
	}
	
	public String exec(){
		return SUCCESS;
	}

	public String insertreply(){
		
		if((re.getReply()==null)||(re.getReply().trim().length()==0)){
			this.addFieldError("re.reply", "回复内容不能为空！");
		}
		
		if(this.hasErrors()==true){
			return INPUT;
		}
		
		boolean result=rd.insertreply(re);
		if(result==true){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
	public String udatereply(){
		if((re.getReply()==null)||(re.getReply().trim().length()==0)){
			this.addFieldError("re.reply", "回复内容不能为空！");
		}
		if(this.hasErrors()==true){
			return INPUT;
		}
		boolean result=rd.updatereply(re);
		if(result==true){
			return SUCCESS;
		}
			return INPUT;
	}
	
	
	public String deletereply(){
		boolean result=rd.deletereply(re.getReplyid());
		if(result==true){
		return SUCCESS;
	}else{
		return INPUT;
	}
	}
		
	
	public Reply getRe() {
		return re;
	}

	public void setRe(Reply re) {
		this.re = re;
	}
}
