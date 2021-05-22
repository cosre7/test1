<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>여정 등록1</title>
</head>
<body>
<h1>여정 등록: 2단계</h1>
<p>함께 할 라이더를 찾아볼까요!</p>
<form action='add' method='post'>
<h2>상세 옵션</h2>
라이더 좌석 선택<br>
보조석: <input type='text' name='seatPsng'><br>
뒷좌석: <input type='text' name='seatRear'><br>
반려동물 탑승: 

<input type='radio' name='pet' value='1'>
<label for='pet'>예</label>&nbsp;&nbsp;&nbsp;
<input type='radio' name='pet' value='0'>
<label for='pet'>아니오</label><br>
여정 운임: <input type='text' name='fee'>원<br>
<h2>여정 설명</h2>
<textarea name='journeyContent' rows='10' cols='60'></textarea><br>
<p><input type='submit' value='여정 등록하기'>
<a href='list'>취소</a></p>
</form>
</body>
</html>
