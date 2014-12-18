package com.shinowit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import com.shinowit.model.Reply;
import com.shinowit.model.UserInfo;

@Service
public class ReplyDao {

	@Resource
	private JdbcTemplate jt;
	
	public boolean insertreply(Reply re){
		boolean result= false;
		int i = jt.update(" insert into reply(userid,reportid,reply,replyday) values(?,?,?,getdate()) ",new Object[]{re.getUserid(),re.getReportid(),re.getReply()}, new int[]{Types.INTEGER,Types.INTEGER,Types.VARCHAR});
		result=i>0;
		return result;
	}
	
	public List<Reply> queryreply(int reportid){
		final List<Reply> result=new ArrayList<Reply>();
		jt.query(" SELECT  * FROM  reply a INNER JOIN userinfo b ON a.userid = b.userid where a.reportid=? ",new Object[]{reportid} , new int[]{Types.INTEGER} , new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Reply re=new Reply();
				re.setReplyid(rs.getInt("replyid"));
				re.setReply(rs.getString("reply"));
				re.setReportid(rs.getInt("reportid"));
				re.setReplyday(rs.getTimestamp("replyday"));
				re.setUserid(rs.getInt("userid"));
				
				UserInfo user=new UserInfo();
				user.setUserid(rs.getInt("userid"));
				user.setUserName(rs.getString("username"));
				re.setUserinfo(user);
				result.add(re);
			}
		});
		return result;
	}
	
	public boolean updatereply(Reply re){
		boolean result=false;
		 int i =jt.update("update reply set reply=? , replyday=getdate()  where replyid=?" , new Object[]{re.getReply(),re.getReplyid()}, new int[]{Types.VARCHAR,Types.INTEGER});
		 result=i>0;
		 return result;
	}
	
	public boolean deletereply(int replyid){
		boolean result=false;
		int i = jt.update(" delete from reply where replyid=? " , new Object[]{replyid}, new int[]{Types.INTEGER});
		result=i>0;
		return result;
	}
	
	public boolean deletere(int reportid){
		boolean result=false;
		int i = jt.update(" delete from reply where reportid=?  " ,new Object[]{reportid},new int[]{Types.INTEGER});
		result=i>0;
		return result;
	}
	
}
