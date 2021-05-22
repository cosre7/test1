package com.talat.pms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.QnA;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@SuppressWarnings("serial")
@WebServlet("/qna/rider/update")
public class RiderQnAUpdateHandler extends HttpServlet {

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

      QnA q = new QnA();
      q.setNo(Integer.parseInt(request.getParameter("qtype")));
      if (Integer.parseInt(request.getParameter("qtype")) == 1) {
        q.setTypeTitle("분실물 문의");
      } else if (Integer.parseInt(request.getParameter("qtype")) == 2) {
        q.setTypeTitle("안전문제보고");
      } else if (Integer.parseInt(request.getParameter("qtype")) == 3) {
        q.setTypeTitle("파트너의 의견 제공");
      } else if (Integer.parseInt(request.getParameter("qtype")) == 4) {
        q.setTypeTitle("여정 관련 고객지원");
      }
      rq.setQtype(q);
      rq.setqContent(request.getParameter("qContent"));
      rq.setFile(request.getParameter("file"));

      riderQnAService.update(rq);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






