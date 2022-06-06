/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.DTO;

/**
 *
 * @author NhatTan
 */
public class ViolationTicketDTO {

    private String violationTicketID;
    private String bookingTicketID;
    private String decription;
    private String ticketStatus;
    private String staffID;

    public ViolationTicketDTO(String violationTicketID, String bookingTicketID, String decription, String ticketStatus, String staffID) {
        this.violationTicketID = violationTicketID;
        this.bookingTicketID = bookingTicketID;
        this.decription = decription;
        this.ticketStatus = ticketStatus;
        this.staffID = staffID;
    }

    public String getViolationTicketID() {
        return violationTicketID;
    }

    public void setViolationTicketID(String violationTicketID) {
        this.violationTicketID = violationTicketID;
    }

    public String getBookingTicketID() {
        return bookingTicketID;
    }

    public void setBookingTicketID(String bookingTicketID) {
        this.bookingTicketID = bookingTicketID;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
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
