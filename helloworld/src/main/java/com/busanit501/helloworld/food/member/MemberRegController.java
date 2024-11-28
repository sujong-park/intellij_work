package com.busanit501.helloworld.food.member;

import com.busanit501.helloworld.food.dto.MemberDTO;
import com.busanit501.helloworld.food.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name="MemberRegController", urlPatterns = "/member/register")
public class MemberRegController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 화면전달
        request.getRequestDispatcher("/WEB-INF/member/memberRegister.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO memberDTO = MemberDTO.builder()
                .mid(request.getParameter("mid"))
                .mpw(request.getParameter("mpw"))
                .mname(request.getParameter("mname"))
                .build();
        try {
            memberService.memberRegister(memberDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/member/list");
    }
}
