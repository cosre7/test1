package com.talat.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/journey/add2")
public class JourneyAdd2Handler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>여정 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>여정 등록: 2단계</h1>");
    out.println("<p>함께 할 라이더를 찾아볼까요!</p>");

    //    Journey j = new Journey();
    //    j.setDeparture((String) session.getAttribute("departure"));
    //    j.setArrival((String) session.getAttribute("arrival"));
    //    j.setJourneyDate(Date.valueOf((String) session.getAttribute("journeyDate")));
    //    j.setJourneyTime(Time.valueOf((String) session.getAttribute("journeyTime")));
    //
    //    out.printf("출발지: <input type='text' name='departure' value='%s' readonly><br>\n", j.getDeparture());
    //    out.printf("도착지: <input type='text' name='arrival' value='%s' readonly><br>\n", j.getArrival());
    //    out.printf("날짜: <input type='date' name='journeyDate' value='%s' readonly><br>\n", j.getJourneyDate());
    //    out.printf("시간: <input type='time' name='journeyTime' value='%s' readonly><br>\n<br><br>\n", j.getJourneyTime());

    out.println("<form action='add' method='post'>");
    out.println("<h2>상세 옵션</h2>");
    out.println("라이더 좌석 선택<br>");
    out.println("보조석: <input type='text' name='seatPsng'><br>");
    out.println("뒷좌석: <input type='text' name='seatRear'><br>");
    out.println("반려동물 탑승: \n");
    out.println("<input type='radio' name='pet' value='1'>");
    out.println("<label for='pet'>예</label>&nbsp;&nbsp;&nbsp;");
    out.println("<input type='radio' name='pet' value='0'>");
    out.println("<label for='pet'>아니오</label><br>");

    out.println("여정 운임: <input type='text' name='fee'>원<br>");

    out.println("<h2>여정 설명</h2>");

    out.println("<textarea name='journeyContent' rows='10' cols='60'></textarea><br>");

    out.println("<p><input type='submit' value='여정 등록하기'>");
    out.println("<a href='list'>취소</a></p>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");

  }
}






