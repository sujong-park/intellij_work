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
    <form action="/member/update?mid=${dto.mid}" method="post">
    <div>
        <input type="text" name="mid" value="${dto.mid}">
    </div>
    <div>
        <input type="text" name="mpw" value="${dto.mpw}">
    </div>
    <div>
        <input type="text" name="mname" value="${dto.mname}">
    </div>


    <div>
        <button type="submit">수정</button>
        <a href="/member/list"><button>목록</button></a>
    </div>
    </form>

    <form action="/member/delete?mid=${dto.mid}" method="post">
        <button type="submit">삭제하기</button>
    </form>
</body>
</html>
