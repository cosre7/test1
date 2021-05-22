package com.talat.pms.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.service.JourneyService;

@SuppressWarnings("serial")
@WebServlet("/qna/rider/journey")
public class RiderQnAJourneyHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    try {
      List<Journey> journeys = journeyService.list();
      int maxNo = 0;
      Journey latestJourney = null;
      for (Journey j : journeys) {
        if (j.getJno() == 1) {
          maxNo = j.getJno();
        } else {
          if (maxNo < j.getJno()) {
            maxNo = j.getJno();
            latestJourney = j;
          }
        }
      }

      request.setAttribute("latestJourney", latestJourney);
      // 목록 출력을 JSP에게 맡긴다.
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/riderQnA/journey_list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






