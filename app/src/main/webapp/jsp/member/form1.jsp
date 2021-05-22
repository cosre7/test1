<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원가입_기본정보</title>
</head>
<body>
<h1>회원가입_기본정보 </h1>
<form action='add2' method='post'>
이름<br>
<input type='text' name='mname'><br>
이메일<br>
<input type='text' name='email'><br>
비밀번호<br>
<input type='password' name='password'><br>
전화번호<br>
<input type='text' name='tel' placeholder='-를 제외하고 입력하세요'><br>
생년월일<br>
<input type='date' name='birth'><br>
타입선택<br>
<input type='radio' name='mType' id="mType" value='1'>라이더
<input type='radio' name='mType' id="mType" value='2'>드라이버<br>
<input type='submit' value='등록'> <a href='list'>취소</a>
</form>
</body>
</html>