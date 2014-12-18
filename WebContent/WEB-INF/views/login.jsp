<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例</title>
<%@ include file="/common/commonhead.jsp"%>

<script type="text/javascript">

$(function(){
	$("#yzm").click(function(){
		document.getElementById("yzm").src="<%=request.getContextPath()%>/validCode.jsp?r="+Math.random();
	});
	
});

</script>

</head>

<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=request.getContextPath()%>/Images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            	<a href="<%=request.getContextPath()%>/login/logfirst">登陆</a>&nbsp;&nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>/reg/first">注册</a>
            </div>
        </div>
        <div id="log">
			<s:form id="loginForm"   action="userlog"  namespace="/login"  method="post" theme="simple">
        	<div id="ctopd">用户登录</div>
			<div id="cmopd">
				<ul>
					<li><strong class="ltt">登录名：</strong><s:textfield name="user.userName"  cssClass="ltx"></s:textfield></li>
					<li><strong class="ltt">密 码：</strong><s:password name="user.userPass"  cssClass="ltx"></s:password></li>
					<li><strong class="ltt">验证码：</strong><s:textfield name="yzm"  cssClass="tc" maxlength="4"></s:textfield><img src="<%=request.getContextPath()%>/validCode.jsp"  id="yzm"/></li>
				</ul>
				<s:iterator value="fieldErrors">
					<s:iterator value="value" status="stat">
						<script type="text/javascript">
							alert("<s:property value='value.get(#stat.index).toString()'/>");
						</script>
					</s:iterator>
				</s:iterator>
			</div>
			<div id="cfopd">
				<input type="submit" class="btn_sub" value="登 录" />
				<input type="button" class="btn_res" value="返 回" />
			</div>
			</s:form>
        </div>

		<div id="footer">
			<img src="<%=request.getContextPath()%>/Images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
</body>
</html>
