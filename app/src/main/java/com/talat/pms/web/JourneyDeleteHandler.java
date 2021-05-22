package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.service.JourneyService;

@SuppressWarnings("serial")
@WebServlet("/journey/delete")
public class JourneyDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    try {
      int no = Integer.parseInt(request.getParameter("jno"));

      Journey oldJourney = journeyService.get(no);

      if (oldJourney == null) {
        throw new Exception("해당 번호의 여정이 없습니다.");
      }

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (oldJourney.getDriver().getMno() != loginUser.getMno()) {
      //        throw new Exception("삭제 권한이 없습니다!");
      //      }

      journeyService.delete(no);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






