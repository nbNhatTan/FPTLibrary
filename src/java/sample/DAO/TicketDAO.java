/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.DAO;

/**
 *
 * @author NhatTan
 */
public class TicketDAO {

    private static final String GETLISTTICKET_USERID = "SELECT bookItemID, borrowDate, expiredDate, returnDate FROM tblBookingTicket WHERE userID = ?";
    private static final String GETLISTTICKET_STATUS = "SELECT bookItemID, borrowDate, expiredDate, returnDate FROM tblBookingTicket WHERE borrowStatus = ?";
    private static final String GETLISTVIOLATIONTICKET_STAFFID = "SELECT bookTicketID, description, ticketStatus FROM tblViolationTicket WHERE borrowStatus = ?";
    private static final String GETVIOLATIONTICKET_BOOKINGTICKETID = "SELECT bookTicketID, description, ticketStatus FROM tblViolationTicket WHERE borrowStatus = ?";
    private static final String CREATE_BOOKINGTICKET = "INSERT INTO tblBookingTicket(userID, bookItemID, borrowDate, expiredDate, borrowStatus) VALUES (?,?,?,?,?)";
    private static final String CREATE_VIOLATIONTICKET = "INSERT INTO tblViolationTicket(bookingTicketID, description, ticketStatus, staffID) VALUES (?,?,?,?)";
    private static final String GETLISTTICKET_STAFFID = "SELECT * FROM tblBookingTicket e JOIN tblStaffTicket a ON e.bookingTicketID = a.ticketID WHERE a.staffID = ?";
}
