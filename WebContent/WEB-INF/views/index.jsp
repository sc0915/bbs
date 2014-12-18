<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例</title>
<%@ include file="/common/commonhead.jsp"%>

<script type="text/javascript">

//分页
$(function() {
	$("#demo1").paginate({
		count 		: $("#sumpage").val(),
		start 		: $("#pageid").val(),
		display     : 5,
		border					: true,
		border_color			: '#fff',
		text_color  			: '#fff',
		background_color    	: 'black',	
		border_hover_color		: '#ccc',
		text_hover_color  		: '#000',
		background_hover_color	: '#fff', 
		images					: false,
		mouse					: 'slide',
		onChange:function(page){
		location.href="<%=request.getContextPath()%>/index/index?pageid="+page;
		}
	});
	});

</script>

</head>
<body>
	<s:hidden name="sumpage"  id="sumpage"></s:hidden>
<s:hidden name="pageid" id="pageid"></s:hidden>
	<div id="main">
		<div id="header">
			<img src="<%=request.getContextPath()%>/Images/logo.gif"
				alt="启奥留言板设计案例" />
			<div>
				<a href="<%=request.getContextPath()%>/login/logfirst">登陆</a>&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/reg/first">注册</a>
			</div>
		</div>
		<div id="content">
			<div id="cheader"></div>
			<div id="cmenu">
				<a href="<%=request.getContextPath()%>/edit/editfirst">【我要留言】</a> <a
					href="">【查看所有留言】</a>
			</div>
			<s:iterator value="list">
				<div class="ccon">
					<div class="info">
						<img src="<%=request.getContextPath()%>/Images/templogo.gif"
							alt="" /> <strong><s:property value="userinfo.userName" /></strong>
						<span><s:property value="reportday" /></span>
					</div>
					<div class="liuy">
						<div class="liuyan">
							<s:property  value="report" />
							<div class="com">
								<a
									href="<%=request.getContextPath()%>/reply/replyfirst?re.reportid=<s:property value="reportid"/>">回复此留言</a>&nbsp;&nbsp;&nbsp;
									
									<s:if test="#session.session.userid== userinfo.userid  "  > 								
								<a href="<%=request.getContextPath()%>/reply/deletereportid?re.reportid=<s:property value="reportid"/>">删除</a>
									</s:if>
									
							</div>
						</div>
						<s:iterator value="relist">
							<div class="huifu">
								<font class="hf">[回复]</font>
								<s:property value="reply" />
								回复时间：
								<s:property value="replyday" />
								回复人：
								<s:property value="userinfo.userName" />
								<div class="com">
								<s:if test="#session.session.userid== userinfo.userid  "  >
									<a href="<%=request.getContextPath()%>/reply/upreplyfirst?re.replyid=<s:property value="replyid"/>">修改此回复</a>&nbsp;&nbsp;&nbsp; 
									<a href="<%=request.getContextPath()%>/reply/deletereply?re.replyid=<s:property value="replyid"/>">删除</a>
								</s:if>
								</div>
							</div>
						</s:iterator>
					</div>
				</div>
			</s:iterator>

			<div id="cfooter"></div>

		</div>

			<div class="ccon" style=" margin-left:68px;">
				<%--  分页显示的页数 --%>
				<div id="demo1" style="text-align: center;"></div>
			</div>

				<div  style="float:right">
				<img src="<%=request.getContextPath()%>/Images/logof.gif"
				alt="唐山市启奥职业培训学校" />
					
				</div>	
					
	</div>
</body>
</html>
