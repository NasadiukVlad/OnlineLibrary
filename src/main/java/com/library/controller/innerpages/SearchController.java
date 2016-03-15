package com.library.controller.innerpages;

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
public class SearchController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Map<String, User> users = null;
        ServletContext context = request.getSession().getServletContext();
        Object obj = context.getAttribute("user");


        RequestDispatcher rd = null;

        String title = request.getParameter("searchingTitle");
        context.setAttribute("searchingTitle", title);


        rd = request.getRequestDispatcher("WEB-INF/view/search.jsp");
        rd.forward(request, response);

    }
}
