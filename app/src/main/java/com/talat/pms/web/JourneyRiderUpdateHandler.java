package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

// 여정 변경
@SuppressWarnings("serial")
@WebServlet("/journeyRider/update")
public class JourneyRiderUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>여정 변경</title>");

    try {
      request.setCharacterEncoding("UTF-8");
      int no = Integer.parseInt(request.getParameter("no"));

      JourneyRider oldJourneyRider = journeyRiderService.get(no);
      if (oldJourneyRider == null) {
        throw new Exception("해당 번호의 여정이 없습니다.");
      } 

      JourneyRider journeyRider = new JourneyRider();
      // search 화면
      journeyRiderService.update(journeyRider);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>여정 변경</h1>");
      out.println("<p>여정을 변경하였습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>여정 변경 오류</h1>");
      out.printf("<p>%s</p>\n", e.getMessage());
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");

  }
}






