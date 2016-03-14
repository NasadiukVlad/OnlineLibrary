package com.library.controller.mainpage;

import com.library.model.user.User;
import com.library.service.pages.AvaliableBooksImpl;
import com.library.service.pages.DownloadBooksImpl;

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
 * Created by Vlad on 14.03.2016.
 */
public class DownloadPageController extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.toString());

        ServletContext context = request.getSession().getServletContext();
        Map<String, User> users = null;
        Object obj = context.getAttribute("user");

        DownloadBooksImpl downloadBooks = new DownloadBooksImpl();

        ArrayList bookList = new ArrayList();
        bookList = downloadBooks.getAvaliableBooks();

        context.setAttribute("downloadBooksList", bookList);

        context.setAttribute("user", users);

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("WEB-INF/view/download_books.jsp");
        rd.forward(request, response);

    }
}
