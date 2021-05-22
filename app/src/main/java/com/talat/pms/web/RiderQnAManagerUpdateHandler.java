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
@WebServlet("/qna/rider/manager/update")
public class RiderQnAManagerUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      RiderQnA oldRiderQnA = riderQnAService.get(no);

      if (oldRiderQnA == null) {
        throw new Exception("해당 번호의 라이더 문의가 없습니다.");
      }

      RiderQnA rq = new RiderQnA();
      rq.setNo(oldRiderQnA.getNo());
      rq.setQtype(oldRiderQnA.getQtype());
      rq.setWriter(oldRiderQnA.getWriter());
      rq.setPartner(oldRiderQnA.getPartner());
      rq.setRegisteredDate(oldRiderQnA.getRegisteredDate());
      rq.setStatus(1);
      rq.setqContent(oldRiderQnA.getqContent());
      rq.setaContent(request.getParameter("aContent"));
      rq.setFile(oldRiderQnA.getFile());

      riderQnAService.managerUpdate(rq);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






