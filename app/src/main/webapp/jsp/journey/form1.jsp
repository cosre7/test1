<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>여정 등록1</title>
</head>
<body>
<h1>여정 등록: 1단계</h1>
<p>함께 할 라이더를 찾아볼까요!</p>
<form action='add2' method='post'>
출발지: <input type='text' name='departure'><br>
도착지: <input type='text' name='arrival'><br>
날짜: <input type='date' name='journeyDate'><br>
시간: <input type='time' name='journeyTime'><br>
<p><input type='submit' value='여정 등록하기'>
<a href='list'>취소</a></p>
</form>
</body>
</html>
