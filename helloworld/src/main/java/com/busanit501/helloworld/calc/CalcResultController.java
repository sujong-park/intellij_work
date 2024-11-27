package com.busanit501.helloworld.calc;

// 입력화면 접근은, jsp파일에 직접 적은 안하고,
// 서블릿에 접근
// 서블릿(자바파일) -> 뷰화면(jsp파일)로 전달해줌.

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "calcResultController", urlPatterns = "/calc/result")
public class CalcResultController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 화면에서 전달된 파아미터를 가져오는 메서드, 키와 값의 구조
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        System.out.println("num1 : " + num1 + " num2 : " + num2);


        response.sendRedirect("/calc/input");

    }
}
