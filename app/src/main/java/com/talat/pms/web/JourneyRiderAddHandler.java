package com.talat.pms.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 카풀신청
@SuppressWarnings("serial")
@WebServlet("/journey/rider/add")
public class JourneyRiderAddHandler extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    try {
      JourneyRider jr = new JourneyRider();

      String[] values = request.getParameterValues("journey");
      ArrayList<Journey> journeyList = new ArrayList<>();
      if (values != null) {
        for (String value : values) {
          Journey journey = new Journey();
          journey.setJno(Integer.parseInt(value));
          journeyList.add(journey);
        }
      }
      jr.setJourneys(journeyList);

      journeyRiderService.add(jr);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}