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
public class StaffTicketDTO {

    private String staffID;
    private String ticketID;

    public StaffTicketDTO() {
    }

    public StaffTicketDTO(String staffID, String ticketID) {
        this.staffID = staffID;
        this.ticketID = ticketID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

}
