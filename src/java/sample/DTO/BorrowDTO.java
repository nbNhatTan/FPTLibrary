/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DTO;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BorrowDTO {

    private String image;
    private String bookName;
    private int bookingTicketID;
    private String bookItemID;
    private Date borrowDate;
    private Date expiredDate;
    private Date returnDate;
    private String borrowStatus;

    public BorrowDTO() {
    }

    public BorrowDTO(String image, String bookName, int bookingTicketID, String bookItemID, Date borrowDate, Date expiredDate, Date returnDate, String borrowStatus) {
        this.image = image;
        this.bookName = bookName;
        this.bookingTicketID = bookingTicketID;
        this.bookItemID = bookItemID;
        this.borrowDate = borrowDate;
        this.expiredDate = expiredDate;
        this.returnDate = returnDate;
        this.borrowStatus = borrowStatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookingTicketID() {
        return bookingTicketID;
    }

    public void setBookingTicketID(int bookingTicketID) {
        this.bookingTicketID = bookingTicketID;
    }

    public String getBookItemID() {
        return bookItemID;
    }

    public void setBookItemID(String bookItemID) {
        this.bookItemID = bookItemID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

}
