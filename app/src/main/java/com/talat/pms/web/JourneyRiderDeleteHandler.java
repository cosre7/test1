package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 취소
@SuppressWarnings("serial")
@WebServlet("/journey/rider/delete")
public class JourneyRiderDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      JourneyRider oldJourneyRider = journeyRiderService.get(no);

      if (oldJourneyRider == null) {
        throw new Exception("해당 번호의 여정이 없습니다.");
      }

      journeyRiderService.delete(no);
      response.sendRedirect("list");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






