package com.cosre7.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.service.JoinService;

@SuppressWarnings("serial")
@WebServlet("/join/delete")
public class JoinDeleteHandler extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JoinService joinService = (JoinService) request.getServletContext().getAttribute("joinService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("[회원 삭제]");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (joinService.delete(no) == 0) {
        out.println("해당 번호의 회원이 없습니다.");
      } else {
        out.println("회원을 삭제하였습니다.");
      }
    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }
}






