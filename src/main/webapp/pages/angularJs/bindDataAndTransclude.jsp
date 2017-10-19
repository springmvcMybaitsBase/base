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
	<div ng-controller='MainController'>

<!-- 		<input type="text" ng-model="to" name="to"/> -->

		 	<!-- 调用指令 -->
<!-- 		<div scope-example ng-model="to" on-send="sendMail(email)" from-name="ari@fullstack.io" /> -->
		
		<div siderbar title="Links">
			<ul>
				<li>First Link</li>
				<li>Second Link</li>
			</ul>
		</div>
		
		<div siderbar title="Books">
			<input type="checkbox">儿童图书&nbsp;&nbsp;
			<input type="checkbox">儿童图书&nbsp;&nbsp;
			<input type="checkbox">儿童图书&nbsp;&nbsp;
		</div>
	</div>


	<script type="text/javascript">
		angular.module("myApp", []).directive("scopeExample", function() {
			return {
				restrict : "A",
				scope : false,
				priority : 100,
				scope:{
					ngModel:"=",
					onSend:"&",
					fromName:"@"
				},
				template : "<h6>inside: {{ to }},{{fromName}}</h6>"
			};
		}).controller("MyController", function($scope, $timeout) {

		}).controller("SomeController", function($scope) {

		}).controller("SecondController", function($scope) {

		}).controller("MainController", function($scope) {
			
		}).directive("",function(){
			//transclude:插入，一旦设置就设为true,默认是false,
			//这个会将设置了这个siderbar指令中的内容全部复制到有ng-transclude指令中
			return {
				restrict:"EA",
				scope:{
					title:"@"
				},
				transclude: true,
				template:'<div class="sidebox">\
					<div class="content">\
					<h2 class="header">{{ title }}</h2>\
					<span class="content" ng-transclude>\
					</span>\
					</div>\
					</div>',
				
			};
		})
	</script>
</body>
</html>