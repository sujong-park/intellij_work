package com.busanit501.helloworld.food.member;

import com.busanit501.helloworld.food.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "MemberDeleteController", urlPatterns = "/member/delete")
public class MemberDeleteController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = String.valueOf(request.getParameter("mid"));
        //
        log.info("doPost FoodDeleteController 확인");
        try {
            memberService.memberDelete(mid);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/member/list");
    }
}
