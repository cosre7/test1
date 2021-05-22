<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>라이더 문의 상세</title>
</head>
<body>
<h1>라이더 문의 상세보기</h1>
<form action='update' method='post'>
<table border='1'>
<tbody>
<tr><th>번호</th> <td><input type='text' name='no' value='${riderQnA.no}' readonly></td></tr>
<tr><th>문의 유형</th><td><select name='qtype'>
  <option value='0' disabled>-- 문의유형 --</option>
  <option value='1' ${param.qtype == "1" ? "selected" : ""}>분실물 문의</option>
  <option value='2' ${param.qtype == "2" ? "selected" : ""}>안전문제보고</option>
  <option value='3' ${param.qtype == "3" ? "selected" : ""}>파트너의 의견 제공</option>
  <option value='4' ${param.qtype == "4" ? "selected" : ""}>여정 관련 고객지원</option>
</select></td></tr>
<tr><th>작성자</th> <td><input type='text' name='writer' value='${riderQnA.writer.mname}' readonly></td></tr>
<tr><th>파트너</th> <td><input type='text' name='partner' value='${riderQnA.partner.mname}' readonly></td></tr>
<tr><th>등록일</th> <td><fmt:formatDate value="${riderQnA.registeredDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
<tr><th>답변상태</th>
<jsp:useBean id="riderQnA" type="com.talat.pms.domain.RiderQnA" scope="request"/>
<c:if test="${riderQnA.status == 0}">
  <td>답변대기</td>
</c:if>
<c:if test="${riderQnA.status == 1}">
  <td>답변완료</td>
</c:if>
</tr>
<tr><th>문의 내용</th> <td><textarea name='qContent' rows='10' cols='60'>${riderQnA.qContent}</textarea></td></tr>
<tr><th>문의 답변</th> <td><textarea name='aContent' rows='10' cols='60' readonly>${riderQnA.aContent}</textarea></td></tr>
<tr><th>첨부파일</th> <td><input name='file' type='text' value='${riderQnA.file}'></td></tr>
</tbody>
<tfoot>
<tr><td colspan='2'>
<input type='submit' value='변경'> <a href='delete?no=${riderQnA.no}'>삭제</a> 
</td></tr>
</tfoot>
</table>
</form>
<p><a href='list'>목록</a></p>
</body>
</html>