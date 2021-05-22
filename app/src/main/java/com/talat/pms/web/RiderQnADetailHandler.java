package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@SuppressWarnings("serial")
@WebServlet("/qna/rider/detail")
public class RiderQnADetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      RiderQnA riderQnA = riderQnAService.get(no);
      if (riderQnA == null) {
        throw new Exception("해당 번호의 라이더 문의가 없습니다.");
      }
      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if ( loginUser.getMno() == 1) {
      //        out.println("<input type='submit' value='변경'> ");
      //      }

      request.setAttribute("riderQnA", riderQnA);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/riderQnA/detail.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);    
    }
  }
}






