<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2024-11-21
  Time: 오전 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>foodRegister 화면</h1>
  <form action="/food/register" method="post">
      <div>
          <input type="text" name="foodName" placeholder="메뉴를 입력해주세요">
      </div>
      <div>
          <input type="date" name="dueDate">
      </div>
    <button type="reset">초기화</button>
    <button type="submit">등록</button>
  </form>
</body>
</html>