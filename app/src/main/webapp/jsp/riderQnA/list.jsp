<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.talat.pms.domain.RiderQnA"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>라이더 문의 목록1</title>
</head>
<body>
<h1>라이더 문의 목록</h1>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>문의 유형</th> <th>등록일</th> <th>등록시간</th> <th>상태</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="list" type="List<RiderQnA>" scope="request"/>
<%
SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
for (RiderQnA rq : list) {
%>
  <tr>
  <td><a href='detail?no=<%=rq.getNo()%>'><%=rq.getNo()%></a></td>
  <td><%=rq.getQtype().getTypeTitle()%></td>
  <td><%=formatterDate.format(rq.getRegisteredDate())%></td>
  <td><%=formatterTime.format(rq.getRegisteredDate())%></td>
<%
  if (rq.getStatus() == 0) {
%>
    <td>답변대기</td>
<%
  } else {
%>
    <td>답변완료</td>
<%
  }
%>
  </tr>
<%
}
%>
</tbody>
</table>
</body>
</html>