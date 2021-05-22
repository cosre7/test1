//package com.talat.pms.web;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.sql.Date;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.talat.pms.domain.Member;
//import com.talat.pms.service.MemberService;
//
//@SuppressWarnings("serial")
//@WebServlet("/member/add2")
//public class UserAddHandler extends HttpServlet {
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");
//
//    request.setCharacterEncoding("UTF-8");
//    response.setContentType("text/html;charset=UTF-8");
//    PrintWriter out = response.getWriter();
//
//    Member m = new Member();
//
//    try {
//      m.setMname(request.getParameter("mname"));
//      m.setEmail(request.getParameter("email"));
//      m.setPassword(request.getParameter("password"));
//      m.setTel(request.getParameter("tel"));
//      m.setBirth(Date.valueOf(request.getParameter("birth")));
//      m.setPreferenceGender(Integer.parseInt(request.getParameter("mType")));
//
//      memberService.add(m);
//
//      out.println("<p>성공적으로 회원가입 되었습니다.<p>");
//
//    } catch (Exception e) {
//      StringWriter strWriter = new StringWriter();
//      PrintWriter printWriter = new PrintWriter(strWriter);
//      e.printStackTrace(printWriter);
//      out.println(strWriter.toString());
//    }
//    //    out.println("<meta http-equiv='Refresh' content='1;url=list'>");
//  }
//}