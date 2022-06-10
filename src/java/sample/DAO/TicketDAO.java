/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.DTO.BookingTicketDTO;
import sample.DTO.ViolationTicketDTO;
import sample.Utils.DBUtils;

/**
 *
 * @author NhatTan
 */
public class TicketDAO {

    private static final String GETLISTTICKET_USERID = "SELECT bookItemID, borrowDate, expiredDate, returnDate, borrowStatus FROM tblBookingTicket WHERE userID = ?";//user
    private static final String GETLISTTICKET_STATUS = "SELECT bookItemID, borrowDate, expiredDate, returnDate FROM tblBookingTicket WHERE borrowStatus = ?";//staff
    private static final String GETLISTVIOLATIONTICKET_STAFFID = "SELECT bookTicketID, description, ticketStatus FROM tblViolationTicket WHERE staffID = ?";//staff
    private static final String GETVIOLATIONTICKET_BOOKINGTICKETID = "SELECT bookTicketID, description, ticketStatus, staffID FROM tblViolationTicket WHERE bookTicketID = ?";//user
    private static final String CREATE_BOOKINGTICKET = "INSERT INTO tblBookingTicket(userID, bookItemID, borrowDate, expiredDate, borrowStatus) VALUES (?,?,?,?,?)";
    private static final String CREATE_VIOLATIONTICKET = "INSERT INTO tblViolationTicket(bookingTicketID, description, ticketStatus, staffID) VALUES (?,?,?,?)";
    private static final String GETLISTTICKET_STAFFID = "SELECT bookItemID, borrowDate, expiredDate, returnDate FROM tblBookingTicket e JOIN tblStaffTicket a ON e.bookingTicketID = a.ticketID WHERE a.staffID = ?";

    public List<BookingTicketDTO> GetListTicket_UserID(String userID) throws SQLException {
        List<BookingTicketDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLISTTICKET_USERID);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String bookItemID = rs.getString("bookItemID");
                    Date borrowDate = rs.getDate("borrowDate");
                    Date expiredDate = rs.getDate("expiredDate");
                    Date returnDate = rs.getDate("returnDate");
                    String borrowStatus = rs.getString("borrowStatus");
                    list.add(new BookingTicketDTO(userID, bookItemID, borrowDate, expiredDate, returnDate, borrowStatus));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<BookingTicketDTO> GetListTicket_Status(String status) throws SQLException {
        List<BookingTicketDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLISTTICKET_STATUS);
                ptm.setString(1, status);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String bookItemID = rs.getString("bookItemID");
                    Date borrowDate = rs.getDate("borrowDate");
                    Date expiredDate = rs.getDate("expiredDate");
                    Date returnDate = rs.getDate("returnDate");
                    list.add(new BookingTicketDTO(userID, bookItemID, borrowDate, expiredDate, returnDate, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ViolationTicketDTO> GetListViolationTicket_StaffID(String staffID) throws SQLException {
        List<ViolationTicketDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLISTVIOLATIONTICKET_STAFFID);
                ptm.setString(1, staffID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int bookingTicketID = rs.getInt("bookingTicketID");
                    String desciption = rs.getString("desciption");
                    String ticketStatus = rs.getString("ticketStatus");
                    list.add(new ViolationTicketDTO(bookingTicketID, desciption, ticketStatus, staffID));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public ViolationTicketDTO GetViolationTicket_BookingTicketID(int bookingTicketID) throws SQLException {
        ViolationTicketDTO violation=null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLISTVIOLATIONTICKET_STAFFID);
                ptm.setInt(1, bookingTicketID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String desciption = rs.getString("desciption");
                    String ticketStatus = rs.getString("ticketStatus");
                    String staffID = rs.getString("staffID");
                    violation = new ViolationTicketDTO(bookingTicketID, desciption, ticketStatus, staffID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return violation;
    }
}
