package com.cosre7.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Join;
import com.talat.pms.service.JoinService;

@SuppressWarnings("serial")
@WebServlet("/join/list") 
public class JoinListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JoinService joinService = (JoinService) request.getServletContext().getAttribute("joinService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("[회원 목록]");

    try {
      List<Join> list = joinService.list();

      for (Join join : list) {
        out.printf("%d, %s, %d, %f\n", 
            join.getNo(), 
            join.getNicName(), 
            join.getGender(),
            join.getStarAverage());
      }
    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }

}






