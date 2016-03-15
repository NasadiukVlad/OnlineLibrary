package com.library.controller.innerpages;

import com.library.dao.book.BooksJpaDao;
import com.library.dao.user.UserFavoriteBookJpaDao;
import com.library.domain.book.Books;
import com.library.domain.user.UserFavoriteBooks;
import com.library.model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Vlad on 15.03.2016.
 */
public class FavoriteBooksController extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Map<String, User> users = null;
        ServletContext context = request.getSession().getServletContext();
        Object obj = context.getAttribute("user");


        RequestDispatcher rd = null;

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        String filePath = request.getParameter("filePath");
        String username = (String) context.getAttribute("username");

        UserFavoriteBooks userFavoriteBooks = new UserFavoriteBooks(username,title, description, author, filePath);
        UserFavoriteBookJpaDao userFavoriteBookJpaDao = new UserFavoriteBookJpaDao();

        userFavoriteBookJpaDao.addFavoriteBook(userFavoriteBooks);

        rd = request.getRequestDispatcher("WEB-INF/view/startIndex.jsp");
        rd.forward(request, response);

    }
}
