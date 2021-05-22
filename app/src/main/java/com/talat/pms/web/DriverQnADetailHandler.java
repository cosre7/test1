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
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.service.DriverQnAService;

@SuppressWarnings("serial")
@WebServlet("/driver/qna/detail")
public class DriverQnADetailHandler extends HttpServlet {

  SimpleDateFormat dFormatter = new SimpleDateFormat("yyyy-MM-dd");
  SimpleDateFormat tFormatter = new SimpleDateFormat("HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    DriverQnAService driverQnAService = (DriverQnAService) request.getServletContext().getAttribute("driverQnAService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int no = Integer.parseInt(request.getParameter("no"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>드라이버 문의 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>드라이버 문의 상세보기</h1>");

    try {
      DriverQnA dq = driverQnAService.get(no);
      if (dq == null) {
        out.println("<p>해당 번호의 드라이버 문의가 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>번호</th>"
          + " <td><input type='text' name='no' value='%d' readonly></td></tr>\n", dq.getNo());
      //      out.printf("<tr><th>문의유형</th>"
      //          + " <td><input name='qnaType' type='text' value='%s'></td></tr>\n", dq.getQnaType());
      out.printf("<tr><th>문의내용</th>"
          + " <td><textarea name='qContent' rows='10' cols='60'>%s</textarea></td></tr>\n", dq.getqContent());
      out.printf("<tr><th>작성자</th> <td>%s</td></tr>\n", dq.getWriter().getMname());
      out.printf("<tr><th>등록일</th> <td>%s</td></tr>\n", dFormatter.format(dq.getDate()));
      out.printf("<tr><th>등록시간</th> <td>%s</td></tr>\n", tFormatter.format(dq.getTime()));
      out.printf("<tr><th>답변상태</th> <td>%s</td></tr>\n", dq.getStatus());
      out.printf("<tr><th>첨부파일</th> <td>%s</td></tr>\n", dq.getFile());
      out.printf("<tr><th>답변내용</th> <td>%s</td></tr>\n", dq.getaContent());
      out.println("</tbody>");

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (loginUser != null && dq.getWriter().getNo() == loginUser.getNo()) {
      //        out.println("<tfoot>");
      //        out.println("<tr><td colspan='2'>");
      //        out.println("<input type='submit' value='변경'> "
      //            + "<a href='delete?no=" + dq.getNo() + "'>삭제</a> ");
      //        out.println("</td></tr>");
      //        out.println("</tfoot>");
      //      }

      out.println("</table>");
      out.println("</form>");


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






