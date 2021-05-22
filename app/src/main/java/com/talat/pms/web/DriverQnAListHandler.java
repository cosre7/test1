package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.service.DriverQnAService;


@SuppressWarnings("serial")
@WebServlet("/driver/qna/list")
public class DriverQnAListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 클라이언트가 /board/list 를 요청하면 톰캣 서버가 이 메서드를 호출한다. 

    DriverQnAService driverQnAService = (DriverQnAService) request.getServletContext().getAttribute("driverQnAService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>드라이버 문의 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>드라이버 문의 목록</h1>");

    out.println("<p><a href='form.html'>새 글</a></p>");

    try {
      List<DriverQnA> dQna = driverQnAService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>문의유형</th> <th>작성자</th> <th>등록일</th> <th>등록시간</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (DriverQnA d : dQna) {
        out.printf("<tr>"
            + " <td><a href='detail?no=%1$d'>%d</a></td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%d</td> </tr>\n", 
            d.getNo(), 
            //            d.getQnaType(), 
            d.getWriter().getMname(),
            d.getDate(),
            d.getTime());
      }
      out.println("</tbody>");
      out.println("</table>");

      out.println("<form action='search' method='get'>");
      out.println("<input type='text' name='keyword'> ");
      out.println("<button>검색</button>");
      out.println("</form>");


    } catch (Exception e) {
      // 상세 오류 내용을 StringWriter로 출력한다.
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      // StringWriter 에 들어 있는 출력 내용을 꺼내 클라이언트로 보낸다.
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}






