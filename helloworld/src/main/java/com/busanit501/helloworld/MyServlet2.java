package com.busanit501.helloworld;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet2", urlPatterns = "/my2")
public class MyServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet MyServlet2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet MyServlet2</h1>");
        out.println("</body>");
        out.println("</html>");



    }


}
