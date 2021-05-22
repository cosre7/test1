package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@SuppressWarnings("serial")
@WebServlet("/qna/rider/manager/detail")
public class RiderQnAManagerDetailHandler extends HttpServlet {

  SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
  SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>라이더 문의 상세보기_관리자</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>라이더 문의 상세보기_관리자</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if ( loginUser.getMno() == 1) {
      //        throw new Exception("변경 권한이 없습니다!");
      //      }

      RiderQnA rq = riderQnAService.get(no);

      if (rq == null) {
        out.println("<p>해당 번호의 라이더 문의가 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>번호</th>"
          + " <td><input type='text' name='no' value='%d' readonly></td></tr>\n", rq.getNo());

      out.printf("<tr><th>문의 유형</th>");
      out.println("<td><select name='qtype'>");
      out.printf("  <option value='0' %s>-- 문의유형 --</option>\n", rq.getQtype().getNo() == 0 ? "selected" : "disabled");
      out.printf("  <option value='1' %s>분실물 문의</option>\n", rq.getQtype().getNo() == 1 ? "selected" : "disabled");
      out.printf("  <option value='2' %s>안전문제보고</option>\n", rq.getQtype().getNo() == 2 ? "selected" : "disabled");
      out.printf("  <option value='3' %s>파트너의 의견 제공</option>\n", rq.getQtype().getNo() == 3 ? "selected" : "disabled");
      out.printf("  <option value='4' %s>여정 관련 고객지원</option>\n", rq.getQtype().getNo() == 4 ? "selected" : "disabled");
      out.println("</select></td></tr>");

      out.printf("<tr><th>작성자</th>"
          + " <td><input name='writer' type='text' value='%s' readonly></td></tr>\n", rq.getWriter().getMname());
      out.printf("<tr><th>파트너</th>"
          + " <td><input name='partner' type='text' value='%s' readonly></td></tr>\n", rq.getPartner().getMname());
      out.printf("<tr><th>등록일</th> <td>%s</td></tr>\n", formatterDate.format(rq.getRegisteredDate()));
      out.printf("<tr><th>등록시간</th> <td>%s</td></tr>\n", formatterTime.format(rq.getRegisteredDate()));
      if (rq.getStatus() == 0) {
        out.printf("<tr><th>답변상태</th> <td>답변대기</td></tr>\n");
      } else {
        out.printf("<tr><th>답변상태</th> <td>답변완료</td></tr>\n");
      }
      out.printf("<tr><th>문의 내용</th>"
          + " <td><textarea name='qContent' rows='10' cols='60' readonly>%s</textarea></td></tr>\n", rq.getqContent());
      out.printf("<tr><th>문의 답변</th>"
          + " <td><textarea name='aContent' rows='10' cols='60'>%s</textarea></td></tr>\n", rq.getaContent());
      out.printf("<tr><th>첨부파일</th>"
          + " <td><input name='file' type='text' value='%s'></td></tr>\n", rq.getFile());

      out.println("</tbody>");

      out.println("<tfoot>");
      out.println("<tr><td colspan='2'>");
      out.println("<input type='submit' value='변경'> "
          + "<a href='delete?no=" + rq.getNo() + "'>삭제</a> ");
      out.println("</td></tr>");

      out.println("</tfoot>");

      out.println("</table>");
      out.println("</form>");



    } catch (Exception e) {
      throw new ServletException(e);    
    }
    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}






