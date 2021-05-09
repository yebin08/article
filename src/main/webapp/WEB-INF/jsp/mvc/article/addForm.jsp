<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 쓰기</h3>
<form action="addArticle" method="post">
    <p><input type="text" name="title" placeholder="제목" required autofocus/></p>
    <p><input type="content" name="content"  placeholder="내용" style="width: 100%;height:100px;"required/></p>
    <p><input type="name" name="name"  placeholder="작성자" style="width: 200px;"required/></p>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>