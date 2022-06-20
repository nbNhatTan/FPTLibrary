/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.DAO.BookDAO;
import sample.DTO.BookDTO;
import sample.Error.BookError;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddBookController", urlPatterns = {"/AddBookController"})
public class AddBookController extends HttpServlet {

    private static final String ERROR = "addBook.jsp";
    private static final String SUCCESS = "home.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String bookName = request.getParameter("bookName");
            String quantity = request.getParameter("quantity");
            String bookshelf = request.getParameter("bookshelf");
            String language = request.getParameter("language");
            String description = request.getParameter("description");
            String DDC = request.getParameter("DDC");
            String author = request.getParameter("author");
            String publisher = request.getParameter("publisher");
            String publishYear = request.getParameter("publishYear");
            String image = request.getParameter("image");
            
            boolean checkValidation = true;
            BookError bookError = new BookError();
            BookDAO dao = new BookDAO();

            if (bookName.length() < 2 || bookName.length() > 50) {
                bookError.setBookNameError("BookName must be in [2, 50]");
                checkValidation = false;
            }
            if (quantity.length() < 2 || quantity.length() > 50) {
                bookError.setQuantityError("quantity must be in [2, 50]");
                checkValidation = false;
            }
            if (bookshelf.length() < 2 || bookshelf.length() > 50) {
                bookError.setBookshelfError("bookshelf must be in [2, 50]");
                checkValidation = false;
            }
            if (language.length() < 2 || language.length() > 50) {
                bookError.setLanguageError("language must be in [2, 50]");
                checkValidation = false;
            }
            if (description.length() < 2 || description.length() > 50) {
                bookError.setDescriptionError("description must be in [2, 50]");
                checkValidation = false;
            }
            if (DDC.length() < 2 || DDC.length() > 50) {
                bookError.setDDCError("DDC must be in [2, 50]");
                checkValidation = false;
            }
            if (author.length() < 2 || author.length() > 50) {
                bookError.setAuthorError("BookName must be in [2, 50]");
                checkValidation = false;
            }
            if (publisher.length() < 2 || publisher.length() > 50) {
                bookError.setPublisherError("publisher must be in [2, 50]");
                checkValidation = false;
            }
            if (publishYear.length() < 2 || publishYear.length() > 50) {
                bookError.setPublishYearError("publishYear must be in [2, 50]");
                checkValidation = false;
            }
            if (image.length() < 2 || image.length() > 50) {
                bookError.setImageError("image must be in [2, 50]");
                checkValidation = false;
            }

            if (checkValidation) {
                BookDTO book = new BookDTO(bookName, Integer.parseInt(quantity), bookshelf, language, description, DDC, author, publisher, publishYear, image);
                int checkCreate = dao.createBook(book);
                if (checkCreate !=0) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("BOOK_ERROR", bookError);
            }

        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
