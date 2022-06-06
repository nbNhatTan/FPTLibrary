/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.DTO;

import java.sql.Date;

/**
 *
 * @author NhatTan
 */
public class BookItemDTO {

    private String bookItemID;
    private String bookID;
    private String bookStatus;
    private String packageID;

    public BookItemDTO(String bookItemID, String bookID, String bookStatus, String packageID) {
        this.bookItemID = bookItemID;
        this.bookID = bookID;
        this.bookStatus = bookStatus;
        this.packageID = packageID;
    }

    public String getBookItemID() {
        return bookItemID;
    }

    public void setBookItemID(String bookItemID) {
        this.bookItemID = bookItemID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    @Override
    public String toString() {
        return "FPTLibrary.sample.DTO.Account[ id=" + bookItemID + " ]";
    }

}
