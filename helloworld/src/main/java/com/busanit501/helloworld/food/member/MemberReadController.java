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

@WebServlet(name = "MemberReadController",urlPatterns = "/member/read")
public class MemberReadController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 클릭한 게시글 번호를 가지고 와야함.
            String mid = request.getParameter("mid");
            MemberDTO memberDTO = memberService.memberSelect(mid);
            // 화면에 전달하기.
            request.setAttribute("dto", memberDTO);
            request.getRequestDispatcher("/WEB-INF/member/memberRead.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





}
