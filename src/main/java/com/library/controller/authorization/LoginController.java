package com.library.controller.authorization;


import com.library.dao.user.UsersJpaDao;
import com.library.domain.user.Users;
import com.library.model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Map;

/**
 * Created by ���� on 14.11.2015.
 */


public class LoginController extends HttpServlet {

    public LoginController() {
        super();
    }




    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Map<String, User> users = null;
        ServletContext context = request.getSession().getServletContext();

        RequestDispatcher rd = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsersJpaDao usersJpaDao = new UsersJpaDao();
        Users user = usersJpaDao.getByLogin(username);

        if (user != null) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                context.setAttribute("username", username);
                rd = request.getRequestDispatcher("WEB-INF/view/startIndex.jsp");
            } else if (!user.getUsername().equals(username) ||
                    !user.getPassword().equals(password)) {
                context.setAttribute("error", "Login and password not match!");
                rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
            }
        } else {
            rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");

        }

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        /*try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost/OnlineLibrary?user=postgres&password=qa1234")    ;
                Statement st = conn.createStatement()                                            ;
                ResultSet rs = st.executeQuery("SELECT file FROM public.books WHERE book_id='1'");
                FileOutputStream fos = new FileOutputStream("C:/Users/Vlad/Desktop/retrieved.pdf")) {
            rs.next();
            byte[] fileBytes = rs.getBytes(1);
            fos.write(fileBytes);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }*/

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("WEB-INF/view/login.jsp");
        rd.forward(request, response);

    }


    }

