package com.cosre7.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.talat.pms.domain.Join;
import com.talat.pms.service.JoinService;

@SuppressWarnings("serial")
@WebServlet("/join/add")
public class JoinAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JoinService joinService = (JoinService) request.getServletContext().getAttribute("joinService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
      out.println("[회원 등록]");

      Join join = new Join();
      join.setNicName(request.getParameter("nicName"));
      join.setGender(Integer.parseInt(request.getParameter("gender")));
      join.setPostNo(request.getParameter("postNo"));
      join.setBasicAddress(request.getParameter("basicAddress"));
      join.setDetailAddress(request.getParameter("detailAddress"));
      join.setProfile(request.getParameter("proFile"));
      join.setPreferenceGender(Integer.parseInt(request.getParameter("preferenceGender")));
      join.setRegisteredDate(Date.valueOf(request.getParameter("registeredDate")));
      join.setStarAverage(Double.parseDouble(request.getParameter("starAverage")));

      joinService.add(join);

      out.println("회원을 등록하였습니다.");
    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }
}






