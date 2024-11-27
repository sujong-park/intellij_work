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
<h1>food 상세페이지</h1>
<div>
    <input type="text" name="tno" value="${dto.fno}">
</div>
<div>
    <input type="text" name="title" value="${dto.foodName}">
</div>
<div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
</div>
<div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""}>
</div>

<div>
    <a href="/food/update?fno=${dto.fno}"><button>수정</button></a>
    <a href="/food/list"><button>목록</button></a>
</div>

</body>
</html>
