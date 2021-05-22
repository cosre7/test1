<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 카풀</title>
</head>
<body>
<h1>카풀 신청이 완료되었습니다!</h1>
<form action='add' method='post'>
<input type='text' name='departure' value='${journeyRider.journey.departure}' readonly>
<p><a href='list'>카풀 내역 보기</a></p>
</form>
</body>
</html>