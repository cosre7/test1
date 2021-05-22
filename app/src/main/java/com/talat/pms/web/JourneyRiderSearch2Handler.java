package com.talat.pms.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 여정 검색
@SuppressWarnings("serial")
@WebServlet("/journey/rider/search2")
public class JourneyRiderSearch2Handler extends HttpServlet {

  SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
  SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      HttpSession session = request.getSession();
      session.setAttribute("keyword1", request.getParameter("keyword1"));
      session.setAttribute("keyword2", request.getParameter("keyword2"));
      session.setAttribute("keyword3", request.getParameter("keyword3"));
      session.setAttribute("keyword4", request.getParameter("keyword4"));

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/journeyRider/search2.jsp").include(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }


  }
}
