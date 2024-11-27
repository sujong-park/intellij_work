<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2024-11-21
  Time: 오후 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>member 상세페이지</h1>
<div>
    <input type="text" name="userNo" value="${dto.userNo}">
</div>
<div>
    <input type="text" name="userId" value="${dto.userId}">
</div>
<div>
    <input type="text" name="userPassword" value="${dto.userPassword}">
</div>
<div>
    <input type="text" name="userName" value="${dto.userName}">
</div>
<div>
    <input type="text" name="userEmail" value="${dto.userEmail}">
</div>
<div>
    <input type="text" name="userPhone" value="${dto.userPhone}">
</div>
<div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
</div>

<div>
    <a href="/member/update?userNo=${dto.userNo}"><button>수정</button></a>
    <a href="/member/list"><button>목록</button></a>
</div>

</body>
</html>
