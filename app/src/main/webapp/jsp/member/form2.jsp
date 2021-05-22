<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원가입_추가정보</title>
</head>
<body>
<h1>회원가입_추가정보</h1>
<form action='add' method='post'>
닉네임<br>
<input type='text' name='nicName'><br>
성별<br>
<input type='radio' name='gender' value='1'>남자 
<input type='radio' name='gender' value='0'>여자<br>
우편번호<br>
<input type='text' name='postNo'><br>
기본주소<br>
<input type='text' name='basicAddress'><br>
상세주소<br>
<input type='text' name='detailAddress'><br>
프로필사진 등록<br>
<input type='file' name='profile' accept='image/*'><p style='color:red;'>주의_얼굴이 나온 사진첨부</p><br>
선호성별<br>
<input type='radio' name='preferenceGender' value='1'>남자  
<input type='radio' name='preferenceGender' value='0'>여자<br>
별점<br>
<input type='text' name='starAverage' value='5.0' readonly><br>
<input type='submit' value='등록'> <a href='list'>취소</a>
</form>
</body>
</html>
    