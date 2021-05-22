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
import com.talat.pms.domain.Review;
import com.talat.pms.service.ReviewService;


@SuppressWarnings("serial")
@WebServlet("/review/list")
public class ReviewListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 클라이언트가 /review/list 를 요청하면 톰캣 서버가 이 메서드를 호출한다. 

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>리뷰 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>리뷰 목록</h1>");

    try {
      List<Review> reviews = reviewService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>리뷰 메세지</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Review r : reviews) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td>[%s]</td>", 
            r.getNo(), 
            r.getReview());
      }
      out.println("</tbody>");
      out.println("</table>");

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






