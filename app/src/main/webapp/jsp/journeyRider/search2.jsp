<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>여정 검색</title>
</head>
<body>
<h1>함께 할 드라이버를 찾아볼까요!</h1>
<form>
<input type='text' name='keyword1' value='${param.keyword1}'>
<input type='text' name='keyword2' value='${param.keyword2}'><br>
<input type='date' name='keyword3' value='${param.keyword3}'>
<input type='time' name='keyword4' value='${param.keyword4}'><br>
</form>
</body>
</html>
      