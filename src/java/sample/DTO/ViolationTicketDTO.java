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

    private int violationTicketID;
    private int bookingTicketID;
    private String description;
    private String ticketStatus;
    private String staffID;

    public ViolationTicketDTO(int bookingTicketID, String description, String ticketStatus, String staffID) {
        this.bookingTicketID = bookingTicketID;
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
