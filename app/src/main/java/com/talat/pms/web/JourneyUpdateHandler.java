package com.talat.pms.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.Member;
import com.talat.pms.service.JourneyService;

@SuppressWarnings("serial")
@WebServlet("/journey/update")
public class JourneyUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");

    try {
      int no = Integer.parseInt(request.getParameter("jno"));

      Journey oldJourney = journeyService.get(no);

      if (oldJourney== null) {
        throw new Exception("해당 번호의 여정이 없습니다.");
      } 

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldJourney.getDriver().getMno() != loginUser.getMno()) {
        throw new Exception("변경 권한이 없습니다!");
      }

      Journey j = new Journey();
      j.setJno(oldJourney.getJno());
      j.setDeparture(request.getParameter("departure"));
      j.setArrival(request.getParameter("arrival"));
      j.setJourneyDate(Date.valueOf(request.getParameter("journeyDate")));
      j.setJourneyTime(Time.valueOf(request.getParameter("journeyTime")));
      j.setSeatPassenger(Integer.parseInt(request.getParameter("seatPassenger")));
      j.setSeatRear(Integer.parseInt(request.getParameter("seatRear")));
      j.setPet(Integer.parseInt(request.getParameter("pet")));
      j.setFee(Integer.parseInt(request.getParameter("fee")));
      j.setContent(request.getParameter("content"));

      journeyService.update(j);

      response.sendRedirect("list");


    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






