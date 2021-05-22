<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>여정 상세정보</title>
</head>
<body>
<h1>여정 상세정보</h1>
<form action='search2' method='post'>
<table border='1'>
<tbody>
<tr><th>여정번호</th> <td>${journey.jno}</td></tr>
<tr>
<th>드라이버</th><td>${journey.driver.mname}</td>
<th>평균 별점</th><td>${journey.driver.starAverage}</td>
</tr>
<tr><th>차량정보</th><td>차량색상|차량모델명|차량번호</td></tr>
<tr>
<th>여정 날짜</th><td>${journey.journeyDate}</td>
<th>여정 시간</th><td>${journey.journeyTime}</td>
<th>운임 요금</th><td>${journey.fee}</td>
</tr>
<tr><th>출발지</th><td>${journey.departure}</td></tr>
<tr><th>경유지</th><td></td></tr>
<tr><th>도착지</th><td>${journey.arrival}</td></tr>
<tr>
<th>반려동물 탑승</th><td>${journey.pet}</td>
<th>보조석 인원</th><td>${journey.seatPassenger}</td>
<th>뒷자석 인원</th><td>${journey.seatRear}</td>
</tr>
<tr><th>여정설명</th><td>${journey.content}</td></tr>
<tr>
<td>
  <input type='submit' value='돌아가기'><a href='add1'>카풀신청</a> 
</td>
</tr>
</tbody>
</table>
</form>
</body>
</html>