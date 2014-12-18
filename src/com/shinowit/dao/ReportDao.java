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
import com.shinowit.model.Report;
import com.shinowit.model.UserInfo;

@Service
public class ReportDao {
	
	@Resource
	private JdbcTemplate jt;
	
	@Resource
	private ReplyDao rd;
	

	public boolean insertreport(Report re){
		boolean result=false;
		int i = jt.update(" insert into report(userid,reportday,report) values(?,GETDATE(),?) ",new Object[]{re.getUserid(),re.getReport()}, new int []{Types.INTEGER,Types.VARCHAR});
		result=i>0;
		return result;
	}
	
	public List<Report> queryreport(int pageindex,int pagesize){
		final List<Report> result=new ArrayList<Report>();
		jt.query("select top "+pagesize+" * from report a inner join userinfo b  on a.userid=b.userid   where reportid not in(select top "+(pageindex-1)*pagesize+" reportid from report order by reportday desc )order by reportday desc",new Object[]{},new int[]{},new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Report re=new Report();
				re.setReportid(rs.getInt("reportid"));
				re.setUserid(rs.getInt("userid"));
				re.setReportday(rs.getTimestamp("reportday"));
				re.setReport(rs.getString("report"));
				
				UserInfo user=new UserInfo();
				user.setUserid(rs.getInt("userid"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				re.setUserinfo(user);
				
				result.add(re);
			}
		});
		return result;
	}
	
	public int querysum(){
		int result=0;
		int i = jt.queryForObject("select isnull (count(0),0) from report",Integer.class);
		result=i;
		return result;
	}
	
	public boolean deletereport(int reportid){
		boolean result=false;
		rd.deletere(reportid);
		int i = jt.update(" delete from report where reportid=? " , new Object[]{reportid},new int[]{Types.INTEGER});
		result=i>0;
		return result;
	}
	
	
}
