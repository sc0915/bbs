package com.shinowit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;


import org.springframework.stereotype.Service;

import com.shinowit.model.UserInfo;

@Service
public class UserInfoDao {

	@Resource
	private JdbcTemplate jt;
	
	public boolean reginsert(UserInfo user){
		boolean result=false;
		int i=jt.update("insert into userinfo (username,userpass,passdefend,answer,birthday,sexid,name,email)  values(?,?,?,?,?,?,?,?)",
			new Object[]{user.getUserName(),user.getUserPass(),user.getPassDefend(),user.getAnswer(),user.getBirthday(),user.getSexid(),user.getName(),user.getEmail()}	,
			new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP,Types.INTEGER,Types.VARCHAR,Types.VARCHAR});
		result=i>0;
		return result;
	}
	
	public UserInfo regquery(String username){
		final UserInfo result=new UserInfo();
		jt.query(" select * from userinfo where username=? ",new Object[]{username},new int[]{Types.VARCHAR},new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				result.setUserid(rs.getInt("userid"));
				result.setUserName(rs.getString("username"));
				result.setUserPass(rs.getString("userpass"));
				result.setEmail(rs.getString("email"));
			}
		});
		return result;
	}
}
