/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.DTO;

/**
 *
 * @author NhatTan
 */
public class BookItemDTO {

    private String bookItemID;
    private int bookID;
    private String bookStatus;
    private int packageID;

    public BookItemDTO(String bookItemID, int bookID, String bookStatus, int packageID) {
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

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    @Override
    public String toString() {
        return "FPTLibrary.sample.DTO.Account[ id=" + bookItemID + " ]";
    }

}
