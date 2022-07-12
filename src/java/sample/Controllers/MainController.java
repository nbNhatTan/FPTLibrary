/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NhatTan
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGIN = "Login";
    private static final String SEARCHBOOK_CONTROLLER = "SearchBookController";
    private static final String SEARCHBOOK = "SearchBook";
    private static final String DETAIL_CONTROLLER = "BookDetailController";
    private static final String DETAIL = "Detail";
    private static final String BORROW_CONTROLLER = "BorrowController";
    private static final String BORROW = "Borrow";
    private static final String VIEWBORROW = "Viewborrow";
    private static final String VIEWBORROW_CONTROLLER = "ViewborrowController";
    private static final String RETURN = "Return";
    private static final String RETURN_CONTROLLER = "ReturnController";
    private static final String VIEWBORROWSTAFF = "ViewborrowStaff";
    private static final String VIEWBORROWSTAFF_CONTROLLER = "ViewborrowStaffController";
    private static final String CONFIRM = "Confirm";
    private static final String CONFIRM_CONTROLLER = "ConfirmController";
    private static final String VIOLATIONTICKET = "Violationticket";
    private static final String VIOLATIONTICKET_CONTROLLER = "ViolationticketController";
    private static final String CREATEVIOLATIONTICKET = "CreateViolationticket";
    private static final String CREATEVIOLATIONTICKET_CONTROLLER = "CreateViolationController";
    private static final String VIEWVIOLATIONTICKET = "ViewFineticket";
    private static final String VIEWVIOLATIONTICKET_CONTROLLER = "ViewFineticketController";
    private static final String REGISTER = "Register";
    private static final String REGISTER_CONTROLLER = "RegisterController";
    private static final String ADVANCESEARCH_CONTROLLER = "AdvanceSearchController";
    private static final String ADVANCESEARCH = "AdvanceSearch";
    private static final String UPDATEACCOUNT = "UpdateAccount";
    private static final String UPDATEACCOUNT_CONTROLLER = "UpdateAccountController";
    private static final String VIEWBORROWDETAIL = "View";
    private static final String VIEWBORROWDETAIL_CONTROLLER = "ViewBorrowDetailController";
    private static final String ADDBOOK = "AddBook";
    private static final String ADDBOOK_CONTROLLER = "AddBookController";
    private static final String FEEDBACK="CreateFeedback";
    private static final String CREATEFEEDBACK_CONTROLLER="CreateFeedBackController";
    private static final String VIEW_FEEDBACK="ViewFeedback";
    private static final String VIEWFEEDBACK_CONTROLLER="ViewFeedBackController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SEARCHBOOK.equals(action)) {
                url = SEARCHBOOK_CONTROLLER;
            } else if (DETAIL.equals(action)) {
                url = DETAIL_CONTROLLER;
            } else if (BORROW.equals(action)) {
                url = BORROW_CONTROLLER;
            } else if (VIEWBORROW.equals(action)) {
                url = VIEWBORROW_CONTROLLER;
            } else if (RETURN.equals(action)) {
                url = RETURN_CONTROLLER;
            } else if (VIEWBORROWSTAFF.equals(action)) {
                url = VIEWBORROWSTAFF_CONTROLLER;
            } else if (CONFIRM.equals(action)) {
                url = CONFIRM_CONTROLLER;
            } else if (VIOLATIONTICKET.equals(action)) {
                url = VIOLATIONTICKET_CONTROLLER;
            } else if (CREATEVIOLATIONTICKET.equals(action)) {
                url = CREATEVIOLATIONTICKET_CONTROLLER;
            } else if (VIEWVIOLATIONTICKET.equals(action)) {
                url = VIEWVIOLATIONTICKET_CONTROLLER;
            } else if (REGISTER.equals(action)) {
                url = REGISTER_CONTROLLER;
            } else if (ADVANCESEARCH.equals(action)) {
                url = ADVANCESEARCH_CONTROLLER;
            }else if (UPDATEACCOUNT.equals(action)) {
                url = UPDATEACCOUNT_CONTROLLER;
            }else if (VIEWBORROWDETAIL.equals(action)) {
                url = VIEWBORROWDETAIL_CONTROLLER;
            }else if (ADDBOOK.equals(action)) {
                url = ADDBOOK_CONTROLLER;
            }else if (FEEDBACK.equals(action)) {
                url = CREATEFEEDBACK_CONTROLLER;
            }else if (VIEW_FEEDBACK.equals(action)) {
                url = VIEWFEEDBACK_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController :" + e.toString());
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
