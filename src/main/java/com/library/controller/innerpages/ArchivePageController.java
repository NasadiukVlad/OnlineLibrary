package com.library.controller.innerpages;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ���� on 17.11.2015.
 */
public class ArchivePageController extends HttpServlet {

    public ArchivePageController() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("WEB-INF/view/archive.jsp");
        rd.forward(request, response);
    }
}
