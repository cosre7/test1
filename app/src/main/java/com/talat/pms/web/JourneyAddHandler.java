package com.talat.pms.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.talat.pms.domain.Journey;
import com.talat.pms.service.JourneyService;

@SuppressWarnings("serial")
@WebServlet("/journey/add")
public class JourneyAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    HttpSession session = request.getSession();

    try {
      Journey j = new Journey();

      j.setDeparture((String) session.getAttribute("departure"));
      j.setArrival((String) session.getAttribute("arrival"));
      j.setJourneyDate(Date.valueOf((String) session.getAttribute("journeyDate")));
      j.setJourneyTime(Time.valueOf((String) session.getAttribute("journeyTime")));

      j.setSeatPassenger(Integer.parseInt((String) session.getAttribute("seatPsng")));
      j.setSeatRear(Integer.parseInt((String) session.getAttribute("seatRear")));
      j.setPet(1);
      j.setFee(Integer.parseInt((String) session.getAttribute("fee")));


      journeyService.add(j);

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
      return;
    }
  }
}






