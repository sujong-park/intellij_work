package com.busanit501.helloworld.calc;

//서블릿 = 컨트롤러 역할


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calcInputController", urlPatterns = "/calc/input")
// 웹 브라우저에서, 주소 : http://localhost:8080/calc/input 입력
public class CalcInputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet 호출 함.");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/calc/calc_input.jsp");

        dispatcher.forward(request,response);
    }


}
