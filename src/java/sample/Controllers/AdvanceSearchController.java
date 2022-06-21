/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.DAO.BookDAO;
import sample.DTO.BookDTO;

/**
 *
 * @author NhatTan
 */
@WebServlet(name = "AdvanceSearchController", urlPatterns = {"/AdvanceSearchController"})
public class AdvanceSearchController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "advancedSearch.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String bBookName = request.getParameter("bookName");
            String bAuthor = request.getParameter("author");
            String bPublisher = request.getParameter("publisher");
            String bLanguage = request.getParameter("language");
            BookDAO dao = new BookDAO();
            List<BookDTO> listBook = dao.getListBook(bBookName,bAuthor,bPublisher,bLanguage);
            if (!listBook.isEmpty()) {
                request.setAttribute("ADVANCE_LIST_BOOK", listBook);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at AdvanceSearchController: " + e.toString());
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
