package com.library.controller.mainpage;

import com.library.service.pages.AvaliableBooksImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Vlad on 14.03.2016.
 */
public class AvailiableBooksController extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        AvaliableBooksImpl avaliableBooks = new AvaliableBooksImpl();

        ArrayList bookList = new ArrayList();
        bookList = avaliableBooks.getAvaliableBooks();

        context.setAttribute("booksList", bookList);

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("WEB-INF/view/available_books.jsp");
        rd.forward(request, response);
    }

}
