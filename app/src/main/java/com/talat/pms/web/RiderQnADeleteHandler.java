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
@WebServlet("/qna/rider/delete")
public class RiderQnADeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      RiderQnA oldRiderQnA = riderQnAService.get(no);

      if (oldRiderQnA == null) {
        throw new Exception("해당 번호의 라이더 문의가 없습니다.");
      }

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (oldJourney.getDriver().getMno() != loginUser.getMno()) {
      //        throw new Exception("삭제 권한이 없습니다!");
      //      }

      riderQnAService.delete(no);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






