<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE>
<html>
	<head>
		<base href="<%=basePath%>"/>
		<meta charset="utf-8">
	</head>
	<body>
		<button id="submit">ajax跨域请求</button>
		
		<script src="scripts/jquery/jquery.js"></script>
		<script>
			$(function(){
				$("#submit").click(function(){
					$.ajax({
						"type":"post",
						"url":"http://localhost:8081/mana/ajaxCrossDomain/requestAjax2",
						"dataType":"jsonp",
						"data":"",
						 async : false,
						 jsonp: "callbackparam",
						 jsonpCallback:"jsonpCallback",
						success:function(data){
							 alert(data[0].name);
						},
						error:function(){
							 
						}
				
					});					
				});
			});
		</script>
	</body>
</html>