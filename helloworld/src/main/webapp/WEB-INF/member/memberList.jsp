<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 11. 27.
  Time: 오후 5:36
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
<h1>memberList 화면</h1>
<h2>등록하기</h2>
<h2>${loginInfo.mname}님 환영합니다.</h2>


<a href="/member/register"><button>메뉴등록</button></a>
<ul>
    <c:forEach var="dto" items="${memberList}">
        <li>
            <a href="/member/read?mid=${dto.mid}">
                <span>${dto.mid}</span>
                <span>${dto.mpw}</span>
                <span>${dto.mname}</span>
            </a>
        </li>
    </c:forEach>
</ul>

</body>
</html>
