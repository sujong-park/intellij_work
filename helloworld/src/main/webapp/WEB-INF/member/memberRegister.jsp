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
  <form action="/member/register" method="post">
      <div>
          <input type="text" name="userId" placeholder="아이디 입력">
      </div>
      <div>
          <input type="text" name="userPassword" placeholder="비밀번호 입력">
      </div>
      <div>
          <input type="text" name="userName" placeholder="이름 입력">
      </div>
      <div>
          <input type="text" name="userEmail" placeholder="이메일 입력">
      </div>
      <div>
          <input type="text" name="userPhone" placeholder="전화번호 입력">
      </div>
      <div>
          <input type="date" name="dueDate">
      </div>
    <button type="reset">초기화</button>
    <button type="submit">등록</button>
  </form>
</body>
</html>
