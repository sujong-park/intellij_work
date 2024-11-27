package com.busanit501.helloworld.jdbcex.member;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
import com.busanit501.helloworld.jdbcex.dto.MemberDTO;
import com.busanit501.helloworld.jdbcex.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "MemberUpdateController",urlPatterns = "/member/update")
public class MemberUpdateController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long userNo = Long.parseLong(request.getParameter("userNo"));
            MemberDTO memberDTO = memberService.memberSelect(userNo);

            request.setAttribute("dto", memberDTO);
            request.getRequestDispatcher("/WEB-INF/member/memberUpdate.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDTO memberDTO = MemberDTO.builder()
                .userNo(Long.valueOf(request.getParameter("userNo")))
                .userId(request.getParameter("userId"))
                .userPassword(request.getParameter("userPassword"))
                .userName(request.getParameter("userName"))
                .userEmail(request.getParameter("userEmail"))
                .userPhone(request.getParameter("userPhone"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATE_TIME_FORMATTER))
                .build();
        log.info("memberDTO 수정된 내용: " + memberDTO);
        try {
            memberService.memberUpdate(memberDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/member/list");

    }




}