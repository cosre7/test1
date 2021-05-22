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
@WebServlet("/route/add")
public class RouteAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RouteService routeService = (RouteService) request.getServletContext().getAttribute("routeService");

    Route r = new Route();

    // 클라이언트가 POST 요청으로 보낸 데이터가 UTF-8임을 알려준다.
    request.setCharacterEncoding("UTF-8");

    r.setLatitude(BigDecimal.valueOf(
        Double.parseDouble(request.getParameter("latitude"))));
    r.setLongitude(BigDecimal.valueOf(
        Double.parseDouble(request.getParameter("longitude"))));
    r.setSpotName(request.getParameter("spotName"));
    r.setSpotTime(Time.valueOf(request.getParameter("spotTime")));

    //
    //    // 작성자는 로그인 사용자이다.
    //    HttpServletRequest httpRequest = request;
    //    MemberDriver loginUser = (MemberDriver) httpRequest.getSession().getAttribute("loginUser");
    //    j.setDriver(loginUser);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>경유지 등록</title>");

    try {
      routeService.add(r);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>경유지 등록</h1>");
      out.println("<p>경유지를 등록했습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>경유지 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}






