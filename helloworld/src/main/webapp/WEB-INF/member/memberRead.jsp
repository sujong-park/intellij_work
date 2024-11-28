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
    <input type="text" name="mid" value="${dto.mid}">
</div>
<div>
    <input type="text" name="mpw" value="${dto.mpw}">
</div>
<div>
    <input type="text" name="mname" value="${dto.mname}">
</div>


<div>
    <a href="/member/update?mid=${dto.mid}"><button>수정</button></a>
    <a href="/member/list"><button>목록</button></a>
</div>

</body>
</html>
