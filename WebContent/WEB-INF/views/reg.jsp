<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例</title>
<%@ include file="/common/commonhead.jsp" %>
<script  src="<%=request.getContextPath()%>/my/WdatePicker.js"></script>


<script type="text/javascript">
	$(function(){
		$("#random").click(function(){
			document.getElementById("random").src="<%=request.getContextPath()%>/validCode.jsp?ra=" + Math.random(); 
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
        <div id="log" style="margin-top:10px;">
			<s:form  method="post"  theme="simple"  action="userinfo"  namespace="/reg">
        	<div id="ctopd">用户注册</div>
			<div id="cmopd">
				<ul>
					<li><strong class="ltt">用户名：    </strong><s:textfield name="user.userName"  cssClass="ltx"></s:textfield></li>
					<li><strong class="ltt">用户密码：</strong><s:password  name="user.userPass"  cssClass="ltx"></s:password></li>
					<li><strong class="ltt">确认密码：</strong><s:password  name="pass"  cssClass="ltx"></s:password></li>
					<li><strong class="ltt">密码保护问题：</strong><s:textfield name="user.passDefend" cssClass="ltx"></s:textfield></li>
					<li><strong class="ltt">您的答案：</strong><s:textfield name="user.answer" cssClass="ltx"></s:textfield></li>
					<li><strong class="ltt">出生日期：</strong><s:textfield name="user.birthday" cssClass="ltx"  onclick="WdatePicker()" readonly="true"></s:textfield></li>
					<li><strong class="ltt">性 别：</strong><s:radio name="user.sexid" value="1" list="#{1:'男',2:'女',3:'未知'}"></s:radio></li>
					<li><strong class="ltt">昵 称：</strong><s:textfield name="user.name" cssClass="ltx"></s:textfield></li>
					<li><strong class="ltt">密保邮箱：</strong><s:textfield name="user.email" cssClass="ltx"></s:textfield></li>
					<li><strong class="ltt">验证码：</strong><s:textfield name="yzm" cssClass="tc" maxLength="4"></s:textfield><img src="<%=request.getContextPath()%>/validCode.jsp"  id="random"  name="random"  /></li>
					<li><strong class="ltt">&nbsp;</strong><input type="checkbox" name="tiao" class="ltc" />同意服务条款</li>
				</ul>
			</div>
				<s:iterator value="fieldErrors">
					<s:iterator value="value"  status="state">
						<script type="text/javascript">
							alert("<s:property  value='value.get(#state.index).toString()'/>");
						</script>
				</s:iterator>
			</s:iterator>
			<div id="cfopd">
				<input type="submit"  class="btn_sub"  value="登 录" />
				<input type="button" class="btn_res"  value="返 回" />
			</div>
			</s:form>
        </div>
		<div id="footer">
			<img src="<%=request.getContextPath()%>/Images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
</body>
</html>
