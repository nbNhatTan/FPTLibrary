/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.Controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.DAO.BookDAO;
import sample.DTO.BookDTO;
import sample.DTO.CategoryDTO;
import sample.DTO.Paging.Paging;

/**
 *
 * @author NhatTan
 */
@WebServlet(name = "AdvancedSearchController", urlPatterns = {"/AdvancedSearchController"})
public class AdvancedSearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            CategoryDTO searchCate = new CategoryDTO(0);
            BookDTO searchData = new BookDTO("", "", "", "");
            BookDAO dao = new BookDAO();
            int categoryId = 0;
            int currentBook = 0;
            int searchLimit = 10;
            int currentPage = 1; 
          
            //--------------------------------------------------------------------------------------------
            String bBookName = request.getParameter("bookName"); if(bBookName==null){bBookName = "";}
            String bAuthor = request.getParameter("author"); if(bAuthor==null){bAuthor = "";}
            String bPublisher = request.getParameter("publisher"); if(bPublisher==null){bPublisher = "";}
            String bLanguage = request.getParameter("language"); if(bLanguage==null){bLanguage = "";}
            String categoryId_txt = request.getParameter("categoryId");  
             //-------------- Ép kiểu CategoryID -> không phải -> trả về giá trị mặc định ---------------- 
            try{
                categoryId = Integer.parseInt(categoryId_txt);
                searchCate = new CategoryDTO(categoryId);       
            }catch(NumberFormatException e){
            } finally{
                request.setAttribute("ADVANCED_SEARCH_CATE_DATA", searchCate);
            }
            //--------------------------------------------------------------------------------------------
            try {                   
                searchData = new BookDTO(bBookName,bAuthor,bPublisher,bLanguage);
            } catch (Exception e) {
            } finally { 
                request.setAttribute("ADVANCED_SEARCH_DATA", searchData);
            }   
            //--------------------------------------------------------------------------------------------    
            List<CategoryDTO> listCategory = dao.getAllBookTag();
            if (!listCategory.isEmpty()) {
                request.setAttribute("LIST_CATEGORY", listCategory);
            }
           
            //--------------------------------------------------------------------------------------------
            String currentPage_txt = request.getParameter("currentPage");
            if (currentPage_txt != null) {
                currentPage = Integer.parseInt(currentPage_txt);
            }
            String searchLimit_txt = request.getParameter("searchLimit");
            if (searchLimit_txt != null) {
                searchLimit = Integer.parseInt(searchLimit_txt);
            }    
             
            
            //--------------------------------------AdvanceListPage---------------------------------------
            
            
            int totalPage = dao.countGetListBook_TotalPage(bBookName, bAuthor, bPublisher, bLanguage, categoryId, searchLimit);
            
            currentBook = searchLimit * currentPage - searchLimit;
            Paging page = new Paging(currentPage, totalPage);
            
            //--------------------------------------------------------------------------------------------
            List<BookDTO> 
                listBook = dao.getListBook(bBookName, bAuthor, bPublisher, bLanguage, categoryId, currentBook, searchLimit);
            
             
            
            
                    
//            if (categoryId==0) {
//                listBook = dao.getListBook(bBookName, bAuthor, bPublisher, bLanguage, 0, currentBook, searchLimit);
//            } else {
//                listBook = dao.getListBook(bBookName, bAuthor, bPublisher, bLanguage, categoryId, currentBook, searchLimit);
//            }

            if (!listBook.isEmpty()) {
                request.setAttribute("ADVANCE_LIST_BOOK", listBook);
                request.setAttribute("ADVANCE_LIST_BOOK_PAGE", page);
            } else {
                request.setAttribute("message", "No result!");
            }
        } catch (Exception e) {
            log("Error at AdvanceSearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher("advancedSearch.jsp").forward(request, response);
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
