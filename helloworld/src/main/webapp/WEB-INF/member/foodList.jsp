<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2024-11-21
  Time: 오전 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL 사용하기 준비 단계--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>foodList 화면</h1>
    <h2>등록하기</h2>
    <a href="/food/register"><button>메뉴등록</button></a>
    <h2>조회하기</h2>
    <a href="/food/read?fno=6"><button>메뉴조회</button></a>

    <h3>반복문, forEach 이용, var=변수명, items="데이터 목록",
        begin, end 이용해보기. </h3>
    <ul>
        <c:forEach var="dto" items="${foodList}">
            <li>
                <a href="/food/read?fno=${dto.fno}">
                <span>${dto.fno}</span>
                <span>${dto.foodName}</span>
                <span>${dto.dueDate}</span>
                <span>${dto.finished?"완료":"미완료"}</span>
                </a>
            </li>
        </c:forEach>
    </ul>




</body>
</html>
