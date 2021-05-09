
<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>삭제</h3>
<form action="deleteArticle" method="post">
    <p><input type="articleID" name="articleID" placeholder="게시물번호" required autofocus/></p>
    <p><input type="userID" name="userID" placeholder="사용자아이디" required/></p>
    <p>
        <button type="submit">삭제</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>