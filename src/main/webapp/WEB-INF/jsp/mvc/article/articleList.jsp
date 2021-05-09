<%@ page import="kr.mjc.yebin.web.dao.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<nav><a href="./articleForm">등록</a></nav>
<h3>게시글 목록</h3>

<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= article %>
</p>
<%
    }
%>
</body>
</html>