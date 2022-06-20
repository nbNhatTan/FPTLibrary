/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DTO;

/**
 *
 * @author Admin
 */
public class BookTagDTO {

    private int categoryID;
    private int bookID;

    public BookTagDTO() {
    }

    public BookTagDTO(int categoryID, int bookID) {
        this.categoryID = categoryID;
        this.bookID = bookID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    @Override
    public String toString() {
        return "FPTLibrary.sample.DTO.Account[ id=" + categoryID + " ]";
    }

}
