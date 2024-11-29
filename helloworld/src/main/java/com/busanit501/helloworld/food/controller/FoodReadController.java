package com.busanit501.helloworld.food.controller;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FoodReadController",urlPatterns = "/food/read")
public class FoodReadController extends HttpServlet {
    private FoodService foodService = FoodService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 클릭한 게시글 번호를 가지고 와야함.
            Long fno = Long.parseLong(request.getParameter("fno"));
            FoodDTO foodDTO = foodService.getFood(fno);
            // 화면에 전달하기.
            request.setAttribute("dto", foodDTO);

            // 상세페이지 쿠키 기록
            Cookie findCookie = findCookie(request.getCookies(),"foodViews");
            String cookieValue = findCookie.getValue();
            boolean exists = false;

            if (cookieValue != null && cookieValue.indexOf(fno + "-") >= 0) {
                exists = true;
            }
            if(!exists) {
                cookieValue += fno + "-";
                findCookie.setValue(cookieValue);
                findCookie.setMaxAge(60*60);
                findCookie.setPath("/");

                response.addCookie(findCookie);
            }


            request.getRequestDispatcher("/WEB-INF/food/foodRead.jsp")
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
            findCookie = new Cookie("foodViews", "");
            findCookie.setPath("/");
            findCookie.setMaxAge(60 * 60 * 24);
        }

        return findCookie;
    } // method



}
