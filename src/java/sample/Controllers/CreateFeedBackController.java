/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.DAO.FeedbackDAO;
import sample.DTO.FeedBackDTO;

/**
 *
 * @author anhkhoa
 */
@WebServlet(name = "CreateFeedBackController", urlPatterns = {"/CreateFeedBackController"})
public class CreateFeedBackController extends HttpServlet {

    private static final String ERROR = "borrow.jsp";
    private static final String SUCCESS = "feedback.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            String userID = request.getParameter("userID");
             int bookingTicketID = Integer.parseInt(request.getParameter("bookingTicketID"));
            String feedbackID = request.getParameter("feedbackID");  
            String comment = request.getParameter("comment");

           
            FeedBackDTO feedback = new FeedBackDTO(feedbackID, userID, bookingTicketID, comment);
            FeedbackDAO dao = new FeedbackDAO();
            boolean checkCreate = dao.createFeedback(feedback);
            
            if (checkCreate) {
                url = SUCCESS;
            
        }
    }
    catch (Exception e ) {
            log("ERROR at CreateFeedBackController:" + e.toString());
    }

    
        finally{
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
