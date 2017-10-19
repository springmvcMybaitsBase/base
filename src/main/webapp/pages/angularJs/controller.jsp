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
	<div some-directive>
		
	</div>

	<script type="text/javascript">
		angular.module("myApp", []).directive("someDirective", function() {
			return {
				restrict : "A",
				template : "<h6>msg:{{mainC.msg}}</h6>",
				controllerAs:'mainC',
				controller:function(){
					this.msg = "controller msg";	//这个地方不需要使用$scope参数了，在内部直接使用this
				}
			};
		})
	</script>
</body>
</html>