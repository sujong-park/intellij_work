package com.busanit501.helloworld;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "indexController", urlPatterns = "/")
public class indexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet. index가 호출됨");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");

        dispatcher.forward(request,response);
    }
}
