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
@WebServlet("/join/detail")
public class JoinDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    JoinService joinService = (JoinService) request.getServletContext().getAttribute("joinService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("[회원 상세보기]");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Join join = joinService.get(no);

      if (join == null) {
        out.println("해당 번호의 회원이 없습니다.");
        return;
      }

      out.printf("닉네임: %s\n", join.getNicName());
      out.printf("성별: %s\n", join.getGender());
      out.printf("우편번호: %s\n", join.getPostNo());      
      out.printf("기본주소: %s\n", join.getBasicAddress());
      out.printf("상세주소: %s\n", join.getDetailAddress());
      out.printf("프로필사진: %s\n", join.getProfile());
      out.printf("선호성별: %s\n", join.getPreferenceGender());
      out.printf("등록날짜: %s\n", join.getRegisteredDate());
      out.printf("별점통계: %s\n", join.getStarAverage());

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }
}






