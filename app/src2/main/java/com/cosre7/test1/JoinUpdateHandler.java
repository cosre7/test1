package com.cosre7.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Join;
import com.talat.pms.service.JoinService;

@SuppressWarnings("serial")
@WebServlet("/join/update")
public class JoinUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JoinService joinService = (JoinService) request.getServletContext().getAttribute("joinService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
      out.println("[회원 변경]");

      int no = Integer.parseInt(request.getParameter("no"));

      Join oldJoin = joinService.get(no);
      if (oldJoin == null) {
        out.println("해당 번호의 회원이 없습니다.");
        return;
      }

      Join join = new Join();
      join.setNo(oldJoin.getNo());
      join.setNicName(request.getParameter("nicName"));
      join.setPostNo(request.getParameter("postNo"));
      join.setBasicAddress(request.getParameter("basicAddress"));
      join.setDetailAddress(request.getParameter("detailAddress"));
      join.setProfile(request.getParameter("proFile"));
      join.setPreferenceGender(Integer.parseInt(request.getParameter("preferenceGender")));

      joinService.update(join);

      out.println("회원을 변경하였습니다.");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }
}






