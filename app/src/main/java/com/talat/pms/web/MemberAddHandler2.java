package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/member/add2")
public class MemberAddHandler2 extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    session.setAttribute("mname", request.getParameter("mname"));
    session.setAttribute("email", request.getParameter("email"));
    session.setAttribute("password", request.getParameter("password"));
    session.setAttribute("tel", request.getParameter("tel"));
    session.setAttribute("birth", request.getParameter("birth"));
    session.setAttribute("mType", request.getParameter("mType"));

    response.setContentType("text/html;charset=UTF-8"); 
    request.getRequestDispatcher("/jsp/member/form2.jsp").include(request, response);
  }
}