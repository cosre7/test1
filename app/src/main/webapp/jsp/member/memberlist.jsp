<%@page import="com.talat.pms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<h1>회원 목록(JSP)</h1>
<p><a href='add1'>회원가입</a></p>
<table border='1'>
<thead>
<tr>
<th style='width:100px;'>이름</th> 
<th style='width:100px;'>이메일</th>
<th style='width:150px;'>전화번호</th>
<th style='width:100px;'>생년월일</th>
<th style='width:100px;'>멤버타입</th>
<th style='width:100px;'>닉네임</th>
<th style='width:100px;'>성별</th>
<th style='width:350px;'>우편번호_주소</th>
<th style='width:100px;'>선호성별</th>
<th style='width:100px;'>가입일</th>
<th style='width:50px;'>별점</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="list" type='List<Member>' scope='request'></jsp:useBean>
<%
for (Member m : list) {
%>
<tr>
<td><a href='detail?mno=<%=m.getMno()%>'><%=m.getMname()%></a></td>
<td><%=m.getEmail()%></td>
<td><%=m.getTel()%></td>
<td><%=m.getBirth()%></td>
<td><%=m.getmType()%></td>
<td><%=m.getNicName()%></td>
<td><%=m.getGender()%></td>
<td>[<%=m.getPostNo()%>]<%= m.getBasicAddress()%><%= m.getDetailAddress()%></td>
<td><%=m.getPreferenceGender()%></td>
<td><%=m.getRegisteredDate()%></td>
<td><%=m.getStarAverage()%></td>
</tr>
<%}%>
</tbody>
</table>
</body>
</html>