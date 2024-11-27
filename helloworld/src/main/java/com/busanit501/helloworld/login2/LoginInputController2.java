package com.busanit501.helloworld.login2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginInputController2", urlPatterns = "/login2/input2")
public class LoginInputController2 extends HttpServlet {

    // 접근은 get

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login2/login_input.jsp");

        dispatcher.forward(request,response);
    }
}
