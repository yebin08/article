package kr.mjc.yebin.web.mvc;

import kr.mjc.yebin.web.dao.Article;
import kr.mjc.yebin.web.dao.ArticleDao;
import kr.mjc.yebin.web.dao.User;
import kr.mjc.yebin.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class ArticleController {

    private final ArticleDao ArticleDao;

    @Autowired
    public ArticleController(ArticleDao ArticleDao) {
        this.ArticleDao = ArticleDao;
    }

    /**
     * 게시글 목록 화면
     */
    public void articleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("ArticleList", ArticleDao.listArticles(0, 100));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }



    /**
     * 게시글 삭제 화면
     */
    public void deleteForm(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/deleteForm.jsp")
                .forward(request, response);
    }
    /**
     * 게시글 등록 화면
     */
    public void addForm(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {


        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/addForm.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 상세보기 화면
     */
    public void articleInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int articleId = Integer.parseInt(request.getParameter("articleId"));
        Article article = ArticleDao.getArticle(articleId);
        request.setAttribute("article",article);
        request.getRequestDispatcher("/WEB-INF/jsp/model2/article/articleInfo.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 수정 화면
     */
    public void updateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int articleId = Integer.parseInt(request.getParameter("articleId"));
        Article article = ArticleDao.getArticle(articleId);
        request.setAttribute("article",article);
        request.getRequestDispatcher("/WEB-INF/jsp/model2/article/updateForm.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 등록 액션
     */



    public void addArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.sendRedirect(request.getContextPath() + "/mvc/user/loginForm");
        User user =new User();
        Article Article = new Article();
        Article.setTitle(request.getParameter("title"));
        Article.setContent(request.getParameter("content"));
        Article.setName(request.getParameter("name"));
        Article.setUserId(user.getUserId());

        ArticleDao.addArticle(Article);
        response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");


    }

    /**
     * 게시글 삭제 액션
     */
    public void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int articleId = Integer.parseInt(request.getParameter("articleId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        try {
            int Article = ArticleDao.deleteArticle(articleId, userId);
            HttpSession session = request.getSession();
            session.setAttribute("Article", Article);
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        } catch (EmptyResultDataAccessException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/deleteForm?msg=Wrong articleId or userId");
        }
    }

    /**
     * 게시물 수정 액션
     */
    public void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Article article = new Article();

        try {
            ArticleDao.updateArticle(article);
            HttpSession session = request.getSession();
            session.setAttribute("article", article);
            response.sendRedirect(request.getContextPath() + "/mvc/user/userInfo");
        } catch (EmptyResultDataAccessException e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/user/loginForm?msg=Wrong email or password");
        }
    }


}
