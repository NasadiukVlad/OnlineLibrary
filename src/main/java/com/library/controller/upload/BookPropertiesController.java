package com.library.controller.upload;

import com.library.dao.book.BooksJpaDao;
import com.library.dao.user.UsersJpaDao;
import com.library.domain.book.Books;
import com.library.domain.user.Users;
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
 * Created by Vlad on 14.03.2016.
 */
public class BookPropertiesController extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Map<String, User> users = null;
        ServletContext context = request.getSession().getServletContext();
        Object obj = context.getAttribute("user");
        String filePath = (String) context.getAttribute("filePath");

        RequestDispatcher rd = null;

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String author = request.getParameter("author");

        Books book = new Books(title, description, author, filePath);
        BooksJpaDao booksJpaDao = new BooksJpaDao();

        booksJpaDao.addBook(book);

        rd = request.getRequestDispatcher("WEB-INF/view/startIndex.jsp");
        rd.forward(request, response);

    }
}
