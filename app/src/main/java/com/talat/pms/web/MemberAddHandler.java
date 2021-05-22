package com.talat.pms.web;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    HttpSession session = request.getSession();
    session.setAttribute("mno", request.getParameter("mno"));
    session.setAttribute("nicName", request.getParameter("nicName"));
    session.setAttribute("gender", request.getParameter("gender"));
    session.setAttribute("postNo", request.getParameter("postNo"));
    session.setAttribute("basicAddress", request.getParameter("basicAddress"));
    session.setAttribute("detailAddress", request.getParameter("detailAddress"));
    session.setAttribute("profile", request.getParameter("profile"));
    session.setAttribute("preferenceGender", request.getParameter("preferenceGender"));
    session.setAttribute("starAverage", request.getParameter("starAverage"));

    try {
      Member m = new Member();
      m.setMname((String)session.getAttribute("mname"));
      m.setEmail((String)session.getAttribute("email"));
      m.setPassword((String) session.getAttribute("password"));
      m.setTel((String)session.getAttribute("tel"));
      m.setBirth(Date.valueOf((String) session.getAttribute("birth")));
      m.setmType(Integer.parseInt((String)session.getAttribute("mType")));      
      memberService.add1(m);

      int idx = m.getMno();

      Member m2 = new Member();
      m2.setMno(idx);
      m2.setNicName((String)session.getAttribute("nicName"));
      m2.setGender(Integer.parseInt((String)session.getAttribute("gender")));
      m2.setPostNo((String) session.getAttribute("postNo"));
      m2.setBasicAddress((String)session.getAttribute("basicAddress"));
      m2.setDetailAddress((String)session.getAttribute("detailAddress"));
      m2.setProfile((String)session.getAttribute("profile"));
      m2.setPreferenceGender(Integer.parseInt((String)session.getAttribute("preferenceGender")));
      m.setStarAverage(Double.valueOf((String)session.getAttribute("starAverage")));
      memberService.add2(m2);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}