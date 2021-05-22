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

// 카풀신청
@SuppressWarnings("serial")
@WebServlet("/journey/rider/add1")
public class JourneyRiderAdd1Handler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    try {
      List<Journey> journeys = journeyService.list();
      request.setAttribute("list", journeys);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/journeyRider/form.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);

    }
  }
}