<%@page import="com.talat.pms.domain.Journey"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최근 여정</title>
</head>
<body>
<h1>최근 여정</h1>
<p><a href="#">여정 기록</a></p>
<c:set scope="session" var="latestJourney" value="${latestJourney}"/>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>드라이버</th> <th>출발지</th> <th>도착지</th> <th>시간</th> <th>일자</th>
</tr>
</thead>
<tbody>
<tr>
<td><a href='../../journey/detail?jno=${latestJourney.jno}'>${latestJourney.jno}</a></td>
<td>${latestJourney.driver.mname}</td>
<td>${latestJourney.departure}</td>
<td>${latestJourney.arrival}</td>
<td>${latestJourney.journeyTime}</td>
<td>${latestJourney.journeyDate}</td>
</tr>
</tbody>
</table>
<p><a href='add'>이 여정의 문제 보고</a></p>
</body>
</html>