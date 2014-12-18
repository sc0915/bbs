<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例</title>
<%@ include file="/common/commonhead.jsp"%>
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/ueditorueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/ueditorlang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/common/ueditor.js"></script>
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
			<s:form id="loginForm"  action="edit"  namespace="/edit"  method="post"  theme="simple">
        	<div id="ctopd">发表内容</div>
			<div id="cmopd">
				<ul>
					<s:hidden name="re.userid"  value="%{#session.session.userid}"></s:hidden>
					<s:hidden name="re.report"  id="report"></s:hidden>
					<li><strong class="lts">姓名：</strong><s:property value="%{#session.session.userName}"/></li>
					<li><strong class="lts">邮箱：</strong><s:property value="%{#session.session.email}"/></li>
					<li><strong class="lts">回复：<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
					</li>
				</ul>
			</div>
			<div id="cfopd">
				<input type="submit" class="btn_sub" value="提 交" />
				<input type="button" class="btn_res" value="返 回" />
			</div>
			<s:iterator value="fieldErrors">
				<s:iterator value="value" status="stat">
					<script type="text/javascript">
						alert("<s:property value='value.get(#stat.index).toString()'/>");
					</script>
				</s:iterator>
			</s:iterator>
			</s:form>
        </div>
		<div id="footer">
			<img src="<%=request.getContextPath()%>/Images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
  
    
  <script type="text/javascript">
  var ue = UE.getEditor('editor');
  </script>
    
    
    
    
</body>
</html>
