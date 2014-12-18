package com.shinowit.actions;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shinowit.dao.UserInfoDao;
import com.shinowit.model.UserInfo;

public class UserInfoRegAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private UserInfo user;
	 
	@Resource
	private UserInfoDao ud;
	
	private String pass;
	
	private String yzm;
	
	private boolean tiao;

	
	public String execute(){
		return SUCCESS;
	}
	
	
	public String reg(){
		
		
		if((user.getUserName()==null)||(user.getUserName().trim().length()<1)){
			this.addFieldError("user.username","用户名不能为空！");
		}

		if((user.getUserPass()==null)||(user.getUserPass().trim().length()<1)){
			this.addFieldError("user.userpass","密码不能为空！");
		}
		if((pass!=null)&&(!user.getUserPass().equals(pass))){
			this.addFieldError("pass","两次密码不一致！");
		}
		HttpSession session=ServletActionContext.getRequest().getSession();
		String yzm1=(String)session.getAttribute("rand");
		if((yzm!=null)&&(!yzm.equals(yzm1))){
			this.addFieldError("yzm","验证码不正确！"); 
		}
		if(tiao==true){
			this.addFieldError("tiao", "请同意条款！");
		}
		 
		UserInfo result=ud.regquery(user.getUserName());
		if(null!=result.getUserName()){
			this.addFieldError("user.username","用户名以存在！");
		}	
		
		if(this.hasErrors()==true){
			return INPUT;
		}
		
		boolean result1=ud.reginsert(user);
		if(true==result1){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

	public boolean isTiao() {
		return tiao;
	}

	public void setTiao(boolean tiao) {
		this.tiao = tiao;
	}


	
	
}
