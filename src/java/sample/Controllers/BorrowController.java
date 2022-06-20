/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.DAO.TicketDAO;
import sample.DTO.AccountDTO;
import sample.DTO.BookingTicketDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "BorrowController", urlPatterns = {"/BorrowController"})
public class BorrowController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String bookID = request.getParameter("bookID");
            TicketDAO dao = new TicketDAO();
            String bookItemID = dao.GetBookItemID(Integer.parseInt(bookID));
            HttpSession session = request.getSession();
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");

            long millis = System.currentTimeMillis();
            java.sql.Date borrowDate = new java.sql.Date(millis);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            java.util.Date dat = df.parse("2022-6-14");
            java.util.Date dat1 = df.parse("2022-10-14");
            long date = dat.getTime();
            long date1 = dat1.getTime();
            long fourMonth = date1 - date;

            java.sql.Date expiredDate = new java.sql.Date(millis + fourMonth);
            BookingTicketDTO ticket = new BookingTicketDTO(loginAccount.getAccountID(), bookItemID, borrowDate, expiredDate, null, "Pending");
            dao.createBookingTicket(ticket);

            request.setAttribute("MESSAGE", "Borrow successfully");
        } catch (Exception e) {
            log("Error at BorrowController: " + e.toString());
        } finally {
            request.getRequestDispatcher("ViewborrowController").forward(request, response);
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
