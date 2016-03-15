package com.library.controller.mainpage;

import com.library.model.user.User;
import com.library.service.pages.AvaliableBooksImpl;
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
public class SearchPageController extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.toString());

        ServletContext context = request.getSession().getServletContext();
        Map<String, User> users = null;
        Object obj = context.getAttribute("user");

        String searchingTitle = request.getParameter("searchingTitle");

        AvaliableBooksImpl avaliableBooks = new AvaliableBooksImpl();

        ArrayList searchingBookList = new ArrayList();
        searchingBookList = avaliableBooks.getSearchingBooks(searchingTitle);

        context.setAttribute("searchingBookList", searchingBookList);

        context.setAttribute("user", users);

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("WEB-INF/view/search.jsp");
        rd.forward(request, response);

    }
}
