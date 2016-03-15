package com.library.controller.mainpage;

import com.library.model.user.User;
import com.library.service.pages.DownloadBooksImpl;
import com.library.service.pages.FavoriteBooksImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Vlad on 15.03.2016.
 */
public class FavoriteBooksPageController extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.toString());

        ServletContext context = request.getSession().getServletContext();
        Map<String, User> users = null;
        Object obj = context.getAttribute("user");
        String username = (String) context.getAttribute("username");

        FavoriteBooksImpl favoriteBooks = new FavoriteBooksImpl();

        ArrayList favoriteBooksList = new ArrayList();
        favoriteBooksList = favoriteBooks.getFavoriteBooks(username);

        context.setAttribute("favoriteBooksList", favoriteBooksList);

        context.setAttribute("user", users);

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("WEB-INF/view/favorite_books.jsp");
        rd.forward(request, response);

    }
}
