//package com.talat.pms.web;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.sql.Date;
//import java.sql.Time;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.talat.pms.domain.Journey;
//import com.talat.pms.service.JourneyService;
//
//@SuppressWarnings("serial")
//@WebServlet("/journey/search")
//public class JourneySearchHandler extends HttpServlet {
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    String departure = request.getParameter("departure");
//    String arrival = request.getParameter("arrival");
//    Date journeyDate = Date.valueOf(request.getParameter("journeyDate"));
//    Time journeyTime = Time.valueOf(request.getParameter("journeyTime"));
//
//    response.setContentType("text/html;charset=UTF-8");
//    PrintWriter out = response.getWriter();
//
//    out.println("<!DOCTYPE html>");
//    out.println("<html>");
//    out.println("<head>");
//    out.println("<title>여정 검색</title>");
//    out.println("</head>");
//    out.println("<body>");
//    out.printf("<h1>여정 검색 결과 : %s</h1>\n", departure, arrival, journeyDate, journeyTime);
//
//    try {
//      if ((departure == null || departure.length() == 0)
//          && (arrival == null || arrival.length() == 0)
//          && journeyDate == null && journeyTime == null) {
//        throw new SearchException("검색어를 입력하세요.");
//      }
//
//      JourneyService journeyService = (JourneyService) request.getServletContext().getAttribute("journeyService");
//      List<Journey> list = journeyService.search(departure, arrival, journeyDate, journeyTime);
//
//      if (list.size() == 0) {
//        throw new SearchException("검색어에 해당하는 여정이 없습니다.");
//      }
//
//      out.println("<table border='1'>");
//      out.println("<thead>");
//      out.println("<tr>");
//      out.println("<th>번호</th> <th>출발지</th> <th>도착지</th> <th>여정 날짜</th> <th>시간</th>");
//      out.println("</tr>");
//      out.println("</thead>");
//      out.println("<tbody>");
//
//      for (Journey j : list) {
//        out.printf("<tr>"
//            + " <td>%d</td>"
//            + " <td><a href='detail?no=%1$d'>%s</a></td>"
//            + " <td>%s</td>"
//            + " <td>%s</td>"
//            + " <td>%s</td> </tr>\n", 
//            j.getJno(), 
//            j.getDeparture(), 
//            j.getArrival(),
//            j.getJourneyDate(),
//            j.getJourneyTime());
//      }
//      out.println("</tbody>");
//      out.println("</table>");
//
//    } catch (SearchException e) {
//      out.printf("<p>%s</p>\n", e.getMessage());
//
//    } catch (Exception e) {
//      StringWriter strWriter = new StringWriter();
//      PrintWriter printWriter = new PrintWriter(strWriter);
//      e.printStackTrace(printWriter);
//
//      out.printf("<pre>%s</pre>\n", strWriter.toString());
//    }
//
//    out.println("</body>");
//    out.println("</html>");
//  }
//}
//
//
//
//
//
//
