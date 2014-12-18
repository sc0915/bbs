package com.shinowit.actions;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shinowit.dao.UserInfoDao;
import com.shinowit.model.UserInfo;

public class UserInfoLoginAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	
	@Resource
	private UserInfoDao ud;
	
	private UserInfo user;
	
	private String yzm;
	
	public String execute(){
		return SUCCESS;
	}
	
	public String login(){
		UserInfo result=ud.regquery(user.getUserName());
		if((user.getUserName()==null)||(user.getUserName().trim().length()<1)){
			this.addFieldError("user.username","用户名不能为空！");
		}
		if((user.getUserPass()==null)||(user.getUserPass().trim().length()<1)){
			this.addFieldError("user.userpass","密码不能为空！");
		}
		if(!user.getUserName().equals(result.getUserName())){
			this.addFieldError("user.username","用户名或密码不正确！");
		}
		if(!user.getUserPass().equals(result.getUserPass())){
			this.addFieldError("user.userpass", "用户名或密码不正确！");
		}
		HttpSession session=ServletActionContext.getRequest().getSession();
		String valid=(String)session.getAttribute("rand");
		if((yzm!=null)&&(!yzm.equals(valid))){
			this.addFieldError("yzm","验证码不正确！");
		}
		if(this.hasErrors()==true){
			return INPUT;
		}else{
			ServletActionContext.getContext().getSession().put("session",result);
			return SUCCESS;
		}
	
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	
}
