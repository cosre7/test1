<%@page import="com.talat.pms.domain.JourneyRider"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<!DOCTYPE html>
<html>
<head>
<title>여정 목록</title>
</head>
<body>
<h1>나의 여정내역</h1>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>날짜</th> <th>시간</th> <th>운임요금</th> <th>드라이버</th> <th>출발지</th> <th>도착지</th>
</tr>
</thead>
<tbody>
<%
List<JourneyRider> journeyRiders = (List<JourneyRider>) request.getAttribute("list");
for (JourneyRider jr : journeyRiders) {
%>
<tr>
  <td><a href='detail2?no=<%=jr.getJourneyRiderNo()%>'><%=jr.getJourneyRiderNo()%></a></td>
  <td><%=jr.getJourney().getJourneyDate()%></td>
  <td><%=jr.getJourney().getJourneyTime()%></td>
  <td><%=jr.getJourney().getFee()%></td>
  <td><%=jr.getDriver().getMname()%></td>
  <td><%=jr.getJourney().getDeparture()%></td>
  <td><%=jr.getJourney().getArrival()%></td> 
  </tr>
<%
}
%>
</tbody>
</table>
</body>
</html>
      