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
<title>angular表单验证</title>
<style type="text/css">
input.ng-invalid {
	border: 1px solid red;
}

input.ng-valid {
	border: 1px solid green;
}
</style>
<script type="text/javascript" src="scripts/angular/angular.js"></script>
</head>
<body ng-app="myApp" ng-controller="myController" >
	<form id="aForm" name="aForm" action="angularJs/show">
		<input type="text" name="name" placeholder="{{fields[0].placeholder}}" ng-required="fields[0].isRequired" ng-model="name"/><br /> 
		<input type="text" name="password" placeholder="{{fields[1].placeholder}}" ng-required="fields[1].isRequired" ng-model="password"/><br /> 
		<input type="text" name="email" placeholder="{{fields[2].placeholder}}" ng-required="fields[2].isRequired" na-model="emial"/><br /> 
		<input type="submit" ng-click="submit()" ng-disabled="aForm.name.$invalid || aForm.password.$invalid"/>
	</form>
	<!--
	 &&:有一个false，就是false
	 ||: 有一个是true,就是ture
	 -->
	<script>
		angular.module("myApp", []).controller("myController",function($scope) {
					$scope.fields = [ {
						placeholder : 'Username',
						isRequired : true
					}, {
						placeholder : 'Password',
						isRequired : true
					}, {
						placeholder : 'Email',
						isRequired : false
					} ];
					$scope.submit = function() {
						alert("submit");
						$("#aForm").submit();
					}

				});
	</script>
</body>
</html>