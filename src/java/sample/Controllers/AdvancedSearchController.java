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
import javax.servlet.http.HttpSession;

import sample.DAO.BookDAO;
import sample.DTO.BookDTO;
import sample.DTO.Paging.Paging;
import sun.jvm.hotspot.utilities.IntArray;

/**
 *
 * @author NhatTan
 */
@WebServlet(name = "AdvancedSearchController", urlPatterns = {"/AdvancedSearchController"})
public class AdvancedSearchController extends HttpServlet {

    private static final String ERROR = "advancedSearch.jsp";
    private static final String SUCCESS = "advancedSearch.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            
            BookDAO dao = new BookDAO();
            HttpSession session = request.getSession();
            String bBookName = request.getParameter("bookName");
            String bAuthor = request.getParameter("author");
            String bPublisher = request.getParameter("publisher");
            String bLanguage = request.getParameter("language");
            BookDTO searchData = (BookDTO) session.getAttribute("ADVANCED_SEARCH_DATA");
            try{   //Kiểm tra và khởi tạo dữ liệu nhận từ advancedSearch.jsp
                if(searchData== null) { 
                    searchData = new BookDTO(bBookName,bLanguage,bAuthor,bPublisher);
                }else{
                   bBookName = searchData.getBookName();
                   bAuthor = searchData.getAuthor();
                   bPublisher = searchData.getPublisher();
                   bLanguage = searchData.getLanguage();
                }
            }catch(Exception e){   
            }finally{ // Khởi tạo Session giữ dữ liệu từ advancedSearch.jsp
                session.setAttribute("ADVANCED_SEARCH_DATA", searchData);
            }
            
            int currentBook = 0;
            int searchLimit= 20;
            int currentPage = 1;
            
            int totalPage = dao.countGetListBook_TotalPage(bBookName, bAuthor, bPublisher, bLanguage, searchLimit);
            
            //AdvanceListPage
            
            String currentPage_txt = request.getParameter("currentPage");
            if(currentPage_txt!=null){
                currentPage = Integer.parseInt(currentPage_txt);
            }
            String searchLimit_txt = request.getParameter("searchLimit");
            if(searchLimit_txt!=null){
                searchLimit = Integer.parseInt(searchLimit_txt);
            }
            currentBook = searchLimit*currentPage - searchLimit;
            String totalPage_txt = request.getParameter("");
            if(totalPage_txt!=null){
                totalPage = Integer.parseInt(totalPage_txt);
            }
            
            
            
            Paging page = new Paging(currentPage,totalPage);
            
            //ListBook
            
            List<BookDTO> listBook = dao.getListBook(bBookName,bAuthor,bPublisher,bLanguage,currentBook,searchLimit);
            
            
            
            
            if (!listBook.isEmpty()) {
                request.setAttribute("ADVANCE_LIST_BOOK", listBook);
                request.setAttribute("ADVANCE_LIST_BOOK_PAGE", page);
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
