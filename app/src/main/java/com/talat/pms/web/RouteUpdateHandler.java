package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Route;
import com.talat.pms.service.RouteService;

@SuppressWarnings("serial")
@WebServlet("/route/update")
public class RouteUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RouteService routeService = (RouteService) request.getServletContext().getAttribute("routeService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>경유지 변경</title>");

    try {
      request.setCharacterEncoding("UTF-8");
      int no = Integer.parseInt(request.getParameter("rno"));

      Route oldRoute = routeService.get(no);
      if (oldRoute == null) {
        throw new Exception("해당 번호의 여정이 없습니다.");
      } 
      //
      //      MemberDriver loginUser = (MemberDriver) request.getSession().getAttribute("loginUser");
      //      if (oldJourney.getDriver().getNo() != loginUser.getNo()) {
      //        throw new Exception("변경 권한이 없습니다!");
      //      }

      Route r = new Route();
      r.setRno(oldRoute.getRno());
      r.setLatitude(BigDecimal.valueOf(
          Double.parseDouble(request.getParameter("latitude"))));
      r.setLongitude(BigDecimal.valueOf(
          Double.parseDouble(request.getParameter("longitude"))));
      r.setSpotName(request.getParameter("spotName"));
      r.setSpotTime(Time.valueOf(request.getParameter("spotTime")));
      routeService.update(r);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>경유지 변경</h1>");
      out.println("<p>경유지를 변경하였습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>경유지 변경 오류</h1>");
      out.printf("<p>%s</p>\n", e.getMessage());
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");

  }
}






