package com.library.controller.upload;

import com.library.dao.book.BooksJpaDao;
import com.library.domain.book.Books;
import com.library.model.user.User;


import com.oreilly.servlet.MultipartRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by Vlad on 13.03.2016.
 */

public class BooksUploadController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "D:/uploads/";


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Map<String, User> users = null;
        ServletContext context = request.getSession().getServletContext();
        Object obj = context.getAttribute("user");

        RequestDispatcher rd = null;

        /*String title = request.getParameter("title").toString();
        String description = request.getParameter("description").toString();
        String author = request.getParameter("author").toString();
*/

            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                // Parse the request
                List<FileItem> multiparts = upload.parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + name));
                        System.out.println(UPLOAD_DIRECTORY + name);
                        context.setAttribute("filePath", UPLOAD_DIRECTORY + name );
                    }
                }

                // File uploaded successfully
                request.setAttribute("message", "Your file has been uploaded!");
            }
            catch (Exception e)
            {
                request.setAttribute("message", "File Upload Failed due to " + e);
            }

        rd = request.getRequestDispatcher("WEB-INF/view/creating_book.jsp");
        rd.forward(request, response);


    }

    /**
     * Extracts file name from HTTP header content-disposition
     */

    /*public BooksUploadController() {
        super();
    }



    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Map<String, User> users = null;
        ServletContext context = request.getSession().getServletContext();
        Object obj = context.getAttribute("user");

        RequestDispatcher rd = null;

        String title = request.getParameter("title").toString();
        String description = request.getParameter("description").toString();
        String author = request.getParameter("author").toString();

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        InputStream fileContent = filePart.getInputStream();
        File file = new File(fileContent.toString());

         Books book = new Books(title, description, author, file);
         BooksJpaDao booksJpaDao = new BooksJpaDao();

        booksJpaDao.addBook(book);

        rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
        rd.forward(request, response);
*/
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
}
