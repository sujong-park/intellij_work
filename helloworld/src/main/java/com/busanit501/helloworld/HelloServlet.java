package com.busanit501.helloworld;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {

        // 생명주기 확인용 콘솔 출력
        // 최초 한번 실행됨.
        System.out.println("helloServlet 최초 한번 실행됨.");
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        System.out.println("helloServlet 호출 시 마다 매번 실행됨.");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        System.out.println("helloServlet 소멸 시 한번 실행됨.");
    }
}