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
	<script type="text/javascript" src="scripts/angular/angular.js"></script>
</head>
<body ng-app='myApp' > 
	<!-- directive example -->
	<!-- anjular 设置时间触发器 ：自定义指令-->
	<div ng-controller="myController">
		<my-clock></my-clock>
		
		<div my-clock></div>
	</div>
	
	<script type="text/javascript">
		angular.module("myApp",[]).directive("myClock",function(){
			return {
				restrict:'AE',
				replace:true,
				template:"<h1>时间为：{{time}}</h1>"
			};
		}).controller("myController",function($scope,$timeout){
			$scope.time = new Date().toLocaleString();
			
			var newTime = function(){
				$scope.time = new Date().toLocaleString();
				$timeout(function(){
					newTime();
				},1000);
				
			}
			
			newTime();
			
		});
	</script>
</body>
</html>