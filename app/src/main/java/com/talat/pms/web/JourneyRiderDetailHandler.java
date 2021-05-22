package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.service.JourneyRiderService;

// 여정 상세정보
@SuppressWarnings("serial")
@WebServlet("/journeyRider/detail")
public class JourneyRiderDetailHandler extends HttpServlet {

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JourneyRiderService journeyRiderService = (JourneyRiderService) request.getServletContext().getAttribute("journeyRiderService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int no = Integer.parseInt(request.getParameter("no"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>여정 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>여정 상세정보</h1>");

    try {
      //      JourneyRider jr = journeyRiderService.get(no);
      //      out.println("</body>");
      //      out.println("</html>");
      //      out.println("<form action='update' method='post'>");
      //      // 날짜, 시각
      //      out.printf("<tr><td>%s</td></tr>\n", formatter.format(b.getRegisteredDate()));
      //      // 운임요금
      //      out.printf("<tr><td>%s</td></tr>\n", b.getViewCount());
      //      // 변경
      //      out.println("<input type='submit' value='변경'> ");
      //      // 삭제
      //      out.println("<a href='delete?no=" + b.getNo() + "'>취소</a> ");
      //      // 출발지
      //      // 도착지
      //      out.println("</form>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}






