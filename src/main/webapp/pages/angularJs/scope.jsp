<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="utf-8">
<script type="text/javascript" src="scripts/angular/angular.js"></script>
</head>
<body ng-app='myApp'>
	<!-- directive example -->
	<!-- 子作用域和父作用域的关系 -->
		<div ng-init="someProperty = 'rootscope data'">
			根级作用域：
			1:{{someProperty}},2:{{}}
			<!-- 根级作用域：$rootScope -->
			<div ng-controller="MyController">
				<!-- 父级作用域 -->
				<div ng-init="siblingProperty='moredata'">
					父级作用域 : {{siblingProperty}}
					Inside Div Two: {{ aThirdProperty }}
					<div ng-init="aThirdProperty = 'data for 3rd property'" ng-controller="SomeController">
						<!-- 子级作用域 -->
						Inside Div Three: {{ aThirdProperty }},
						Inside Div Four: {{ aFourthProperty }}
						<div ng-init="aFourthProperty='data for 4th property'">Inside Div Four: {{aThirdProperty }}</div>
					</div>
				</div>
			</div>
		</div>
		<br/><br/>
		<div ng-init="someProperty = 'some data'"></div>
		<div ng-init="siblingProperty='moredata'">
			Inside Div Two: {{ aThirdProperty }}
			<div ng-init="aThirdProperty = 'data for 3rd property'" ng-controller="SomeController">
				Inside Div Three: {{ aThirdProperty }}
				<div ng-controller="SecondController">
					Inside Div Four: {{ aThirdProperty }}
					<br>
<!-- 					Outside myDirective: {{ myProperty }} -->
<!-- 					<div my-directive ng-init="myProperty = 'wow, this is cool'"> -->
<!-- 						Inside myDirective: {{ myProperty }} -->
<!-- 						Inside Div Four: {{ aThirdProperty }} -->
<!-- 					</div> -->
				</div>
			</div>
		</div>
		
		<div ng-controller='MainController'>
			outside: {{ myProperty }}
			<div my-directive ng-init="myProperty = 'wow, this is cool'">
				inside: {{ myProperty }}
			</div>
		</div>
		

	<script type="text/javascript">
		angular.module("myApp", []).directive("myDirective", function() {
			return {
				restrict:"A",
				scope:false,//scope:true->这样就新创建了一个集成作用域, {}：创建一个隔离的作用域, false:不创建作用域
				priority:100,
				template:"<h6>inside: {{ myProperty }}</h6>"
			};
		}).controller("MyController", function($scope, $timeout) {
			

		}).controller("SomeController",function($scope){
			
		}).controller("SecondController",function($scope){
			
		}).controller("MainController",function($scope){
			
		})
	</script>
</body>
</html>