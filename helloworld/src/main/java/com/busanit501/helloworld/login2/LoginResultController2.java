package com.busanit501.helloworld.login2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginResultController2", urlPatterns = "/login2/result2")
public class LoginResultController2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userid");
        String password = request.getParameter("password");


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login2/login_result.jsp");

        dispatcher.forward(request,response);


    }
}
