<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>index.jsp 기본 화면으로 접근하는 방식을, 서블릿 경유</h1>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<button><a href="/login/input">로그인</a></button>
</body>
</html>