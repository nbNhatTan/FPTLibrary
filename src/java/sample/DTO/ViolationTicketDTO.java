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
public class ViolationTicketDTO {

    private int violationTicketID;
    private int bookingTicketID;
    private String description;
    private String ticketStatus;
    private String staffID;
     private Date createDate;

    public ViolationTicketDTO() {
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public ViolationTicketDTO(int bookingTicketID, Date createDate, String description, String ticketStatus, String staffID) {
        this.bookingTicketID = bookingTicketID;
        this.createDate = createDate;
        this.description = description;
        this.ticketStatus = ticketStatus;
        this.staffID = staffID;
    }

    public int getViolationTicketID() {
        return violationTicketID;
    }

    public void setViolationTicketID(int violationTicketID) {
        this.violationTicketID = violationTicketID;
    }

    public int getBookingTicketID() {
        return bookingTicketID;
    }

    public void setBookingTicketID(int bookingTicketID) {
        this.bookingTicketID = bookingTicketID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return "FPTLibrary.sample.DTO.Account[ id=" + violationTicketID + " ]";
    }

}
