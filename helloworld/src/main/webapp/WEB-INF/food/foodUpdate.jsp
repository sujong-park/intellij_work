<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>tno 수정화면</h1>
    <form action="/food/update?fno=${dto.fno}" method="post">
    <div>
        <input type="text" name="fno" value="${dto.fno}">
    </div>
    <div>
        <input type="text" name="foodName" value="${dto.foodName}">
    </div>
    <div>
        <input type="date" name="dueDate" value="${dto.dueDate}">
    </div>
    <div>
        <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""}>
    </div>

    <div>
        <button type="submit">수정</button>
        <a href="/food/list"><button>목록</button></a>
    </div>
    </form>

    <form action="/food/delete?fno=${dto.fno}" method="post">
        <button type="submit">삭제하기</button>
    </form>
</body>
</html>
