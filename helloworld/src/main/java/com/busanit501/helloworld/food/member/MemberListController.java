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
import java.util.List;

@WebServlet(name = "MemberListController", urlPatterns = "/member/list")
public class MemberListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 화면전달
        List<MemberDTO> memberList = null;

        try {
            memberList = MemberService.INSTANCE.membersAllSelect();
            request.setAttribute("memberList", memberList);

            request.getRequestDispatcher("/WEB-INF/member/memberList.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
