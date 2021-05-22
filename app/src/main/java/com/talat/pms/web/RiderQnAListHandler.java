package com.talat.pms.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@SuppressWarnings("serial")
@WebServlet("/qna/rider/list")
public class RiderQnAListHandler extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    try {
      List<RiderQnA> riderQnas = riderQnAService.list();

      request.setAttribute("list", riderQnas);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/riderQnA/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






