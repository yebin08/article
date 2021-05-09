
<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 수정</h3>
<form action="updateArticle" method="post">
    <p><input type="text" name="title" value=""${article.title} autofocus/></p>
    <p><textarea name="content" stule="width: 100%;height : 100px;">%{article.content}</textarea></p>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>