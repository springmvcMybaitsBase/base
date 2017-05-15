<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	</head>
    <body>
        <form id="form" method="post" action="fileUpload" enctype="multipart/form-data">
              <input type="file" name="file" id="file"/>
              <input type="submit" value="提交图片"/>
        </form>
    </body>
</html>