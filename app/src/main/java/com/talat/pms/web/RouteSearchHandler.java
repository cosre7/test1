package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Route;
import com.talat.pms.service.RouteService;

@SuppressWarnings("serial")
@WebServlet("/route/search")
public class RouteSearchHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BigDecimal latitude = BigDecimal.valueOf(
        Double.parseDouble(request.getParameter("latitude")));
    BigDecimal longitude = BigDecimal.valueOf(
        Double.parseDouble(request.getParameter("longitude")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>경유지 검색</title>");
    out.println("</head>");
    out.println("<body>");
    out.printf("<h1>경유지 검색 결과 : %s</h1>\n", latitude, longitude);

    try {
      if (latitude == null && longitude == null) {
        throw new SearchException("검색어를 입력하세요.");
      }

      RouteService routeService = (RouteService) request.getServletContext().getAttribute("routeService");
      List<Route> list = routeService.search(latitude, longitude);

      if (list.size() == 0) {
        throw new SearchException("검색어에 해당하는 경유지가 없습니다.");
      }

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>경로 번호</th> <th>여정 번호</th> <th>경로 순서</th> "
          + "<th>위도</th> <th>경도</th> <th>장소명</th> <th>정차 예상 시간</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Route r : list) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td>%d</td>"
            + " <td>%d</td>"
            + " <td>%f</td>"
            + " <td>%f</td>"
            + " <td><a href='detail?no=%1$d'>%s</a></td>"
            + " <td>%s</td> </tr>\n", 
            r.getRno(), 
            r.getJno(), 
            r.getSpotOrder(),
            r.getLatitude(),
            r.getLongitude(),
            r.getSpotName(),
            r.getSpotTime());
      }
      out.println("</tbody>");
      out.println("</table>");

    } catch (SearchException e) {
      out.printf("<p>%s</p>\n", e.getMessage());

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}






