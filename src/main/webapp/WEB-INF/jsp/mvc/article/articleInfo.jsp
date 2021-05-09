<%@ page import="kr.mjc.yebin.web.dao.User" %>

<!DOCTYPE html>
<html>
<body>
<h3>게시글 조회</h3>
<hr>
<p> ${article.articleID}&nbsp;${article.title}</p>
<p>${article.writer}</p>
<hr>
<p>${article.content}</p>
<hr>
</body>
</html>