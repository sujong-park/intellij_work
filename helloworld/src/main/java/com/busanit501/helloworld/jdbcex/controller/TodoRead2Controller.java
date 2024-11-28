package com.busanit501.helloworld.jdbcex.controller;

import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "TodoRead2Controller", urlPatterns = "/todo/read2")
public class TodoRead2Controller extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet TodoRead2Controller 하나 조회 예제");

        // 서비스에서, 하나의 todo 더미 데이터를 조회 후,
        try {
            // 클릭한 게시글 번호를 가지고 와야함.
            Long tno = Long.parseLong(request.getParameter("tno"));
            TodoDTO todoDTO = todoService.get(tno);
            // 화면에 전달하기.
            request.setAttribute("dto", todoDTO);

            Cookie findCookie = findCookie(request.getCookies(),"viewTodos");
            // 쿠키의 값을 조회
            String cookieValue = findCookie.getValue();
            // 조회한 게시글 번호 -> cooKieValue = "1-3-5-7"
            boolean exists = false;
            // 쿠키의 존재 및 내용의 존재여부
            if (cookieValue != null && cookieValue.indexOf(tno + "-") >= 0) {
                exists = true;
            }
            // 쿠키의 내용이 없을 경우. 추가
            if(!exists) {
                cookieValue += tno + "-";
                findCookie.setValue(cookieValue);
                findCookie.setMaxAge(60*60);
                findCookie.setPath("/");

                response.addCookie(findCookie);
            }

            request.getRequestDispatcher("/WEB-INF/todo/todoRead2.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        Cookie findCookie = null;

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    findCookie = cookie;
                    break;
                }
            }
        }
        if (findCookie == null) {
            findCookie = new Cookie("viewTodos", "");
            findCookie.setPath("/");
            findCookie.setMaxAge(60 * 60 * 24);
        }

        return findCookie;
    } // method




}
