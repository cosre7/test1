package com.talat.pms.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 내역
@SuppressWarnings("serial")
@WebServlet("/journey/rider/list")
public class JourneyRiderListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    try {
      List<JourneyRider> journeyRiders = journeyRiderService.list();

      request.setAttribute("list", journeyRiders);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/journeyRider/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);

    } 
  }
}






