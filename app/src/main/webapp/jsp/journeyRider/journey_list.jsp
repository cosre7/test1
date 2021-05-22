<%@page import="com.talat.pms.domain.Journey"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>여정 목록</title>
</head>
<body>
<h1>여정 목록</h1>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>드라이버</th> <th>출발지</th> <th>도착지</th> <th>시간</th> <th>일자</th>
</tr>
</thead>
<tbody>
<%
List<Journey> list = (List<Journey>) request.getAttribute("list");
for (Journey j : list) {
  out.println("<tr>");
  out.println("<td><a href='detail?jno=" + j.getJno() + "'>" + j.getJno() + "</a></td>");
  out.println("<td>" + j.getDriver().getMname() + "</td>");
  out.println("<td>" + j.getDeparture() + "</td>");
  out.println("<td>" + j.getArrival() + "</td>");
  out.println("<td>" + j.getJourneyTime() + "</td>");
  out.println("<td>" + j.getJourneyDate() + "</td>");
  out.println("</tr>");
}
%>
</tbody>
</table>
</body>
</html>
    