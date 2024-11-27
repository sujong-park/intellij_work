package com.busanit501.helloworld.food.controller;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name="FoodRegController", urlPatterns = "/food/register")
public class FoodRegController extends HttpServlet {

    private com.busanit501.helloworld.food.service.FoodService foodService = FoodService.INSTANCE;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 화면전달
        request.getRequestDispatcher("/WEB-INF/food/memberRegister.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FoodDTO foodDTO = FoodDTO.builder()
                .foodName(request.getParameter("foodName"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),dateTimeFormatter))
                .build();
        try {
            foodService.addFood(foodDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/food/list");
    }
}
