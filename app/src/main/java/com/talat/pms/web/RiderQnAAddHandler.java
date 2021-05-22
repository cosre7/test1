package com.talat.pms.web;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.talat.pms.domain.QnA;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/qna/rider/add")
public class RiderQnAAddHandler extends HttpServlet {

  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/riderQnA/form.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RiderQnAService riderQnAService = (RiderQnAService) request.getServletContext().getAttribute("riderQnAService");

    try {
      RiderQnA rq = new RiderQnA();
      QnA q = new QnA();

      q.setNo(Integer.parseInt(request.getParameter("qtype")));
      if (q.getNo() == 1) {
        q.setTypeTitle("분실물 문의");
      } else if (q.getNo() == 2) {
        q.setTypeTitle("안전문제보고");
      } else if (q.getNo() == 3) {
        q.setTypeTitle("파트너의 의견 제공");
      } else if (q.getNo() == 4) {
        q.setTypeTitle("여정 관련 고객지원");
      }
      rq.setQtype(q);
      rq.setqContent(request.getParameter("qContent"));

      Part photoPart = request.getPart("file");
      if (photoPart.getSize() > 0) {
        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        photoPart.write(this.uploadDir + "/" + filename);
        rq.setFile(filename);

        // 썸네일 이미지 생성
        //        Thumbnails.of(this.uploadDir + "/" + filename)
        //        .size(30, 30)
        //        .outputFormat("jpg")
        //        .crop(Positions.CENTER)
        //        .toFiles(new Rename() {
        //          @Override
        //          public String apply(String name, ThumbnailParameter param) {
        //            return name + "_30x30";
        //          }
        //        });

        //        Thumbnails.of(this.uploadDir + "/" + filename)
        //        .size(80, 80)
        //        .outputFormat("jpg")
        //        .crop(Positions.CENTER)
        //        .toFiles(new Rename() {
        //          @Override
        //          public String apply(String name, ThumbnailParameter param) {
        //            return name + "_80x80";
        //          }
        //        });
      }
      riderQnAService.add(rq);
      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e); 
    }
  }
}








