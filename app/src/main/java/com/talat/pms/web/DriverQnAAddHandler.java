package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.domain.Member;
import com.talat.pms.service.DriverQnAService;

@SuppressWarnings("serial")
@WebServlet("/driver/qna/add")
public class DriverQnAAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    DriverQnAService driverQnAService = (DriverQnAService) request.getServletContext().getAttribute("driverQnAService");

    DriverQnA dQna = new DriverQnA();

    // 클라이언트가 POST 요청으로 보낸 데이터가 UTF-8임을 알려준다.
    request.setCharacterEncoding("UTF-8");

    dQna.setQnaTypeNo(Integer.parseInt(request.getParameter("qnaTypeNo")));
    //    dQna.setQnaType(request.getParameter("qnaType"));
    dQna.setDate(Date.valueOf(request.getParameter("date")));
    dQna.setTime(Time.valueOf(request.getParameter("time")));

    // 작성자는 로그인 사용자이다.
    HttpServletRequest httpRequest = request;
    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
    dQna.setWriter(loginUser);

    dQna.setStatus(Integer.parseInt(request.getParameter("status")));
    dQna.setqContent(request.getParameter("qContent"));
    dQna.setaContent(request.getParameter("aContent"));
    dQna.setFile(request.getParameter("file"));


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>드라이버 문의 등록</title>");

    try {
      driverQnAService.add(dQna);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>드라이버 문의 등록</h1>");
      out.println("<p>드라이버 문의를 등록했습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>드라이버 문의 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}






