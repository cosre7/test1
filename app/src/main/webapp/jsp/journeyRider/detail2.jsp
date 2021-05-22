<%@page import="com.talat.pms.domain.JourneyRider"%>
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
<h1>나의 여정내역</h1>
<p>여정 상세정보</p>
<%
JourneyRider jr = (JourneyRider) request.getAttribute("journeyRider");
if (jr != null) {
%>
<form action='update' method='post'>
<table border='1'>
<tbody>
<tr><th>여정신청번호</th><td><%=jr.getJourneyRiderNo()%></td></tr>
<tr><th>여정 날짜</th><td><%=jr.getJourney().getJourneyDate()%></td></tr>
<tr><th>여정 시간</th><td><%=jr.getJourney().getJourneyTime()%></td></tr>
<tr><th>운임 요금</th><td><%=jr.getJourney().getFee()%></td></tr>
<tr>
<td>
  <input type='submit' value='변경'><a href='delete?no=<%=jr.getJourneyRiderNo()%>'>취소</a> 
</td>
</tr>
</tbody>
<tfoot>
<tr><th>출발지</th> <td><input type='text' name='departure' value='<%=jr.getJourney().getDeparture()%>' readonly></td></tr>
<tr><th>도착지</th> <td><input type='text' name='Arrival' value='<%=jr.getJourney().getArrival()%>' readonly></td></tr>
</tfoot>
<%}%>
</table>
</form>
</body>
</html>