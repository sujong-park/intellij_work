package com.busanit501.helloworld.food.controller;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
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
@WebServlet(name = "FoodUpdateController",urlPatterns = "/food/update")
public class FoodUpdateController extends HttpServlet {
    private FoodService foodService = FoodService.INSTANCE;
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long fno = Long.parseLong(request.getParameter("fno"));
            FoodDTO foodDTO = foodService.getFood(fno);

            request.setAttribute("dto", foodDTO);
            request.getRequestDispatcher("/WEB-INF/food/foodUpdate.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FoodDTO foodDTO = FoodDTO.builder()
                .fno(Long.valueOf(request.getParameter("fno")))
                .foodName(request.getParameter("foodName"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATE_TIME_FORMATTER))
                .finished(Boolean.parseBoolean(request.getParameter("finished")))
                .build();
        log.info("foodDTO 수정된 내용: " + foodDTO);
        // Controller -> Service
        try {
            foodService.updateFood(foodDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("doPost : 글쓰기 처리하는 로직, 디비 연결 전, 리스트로 이동함");
        response.sendRedirect("/food/list");

    }




}
