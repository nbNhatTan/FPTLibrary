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
    //private static final String GETLISTTICKET_STAFFID = "SELECT bookItemID, borrowDate, expiredDate, returnDate FROM tblBookingTicket e JOIN tblStaffTicket a ON e.bookingTicketID = a.ticketID WHERE a.staffID = ?";
    private static final String RETURNBOOK = "UPDATE tblBookingTicket SET returnDate=?, borrowStatus=? WHERE bookingTicketID=?";
    private static final String CONFIRMBOOKINGTICKET = "UPDATE tblBookingTicket SET borrowStatus=? WHERE bookingTicketID=?";
    private static final String UPDATEBOOKITEMSTATUS = "UPDATE tblBookItem SET bookStatus=? WHERE bookItemID= (SELECT bookItemID FROM tblBookingTicket WHERE bookingTicketID = ?)";
    private static final String UPDATEVIOLATIONSTATUS = "UPDATE tblViolationTicket SET ticketStatus=? WHERE violationTicketID=?";

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
        ViolationTicketDTO violation = null;
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

    public int createBookingTicket(BookingTicketDTO ticket) throws SQLException {
        int id = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_BOOKINGTICKET);
                ptm.setString(1, ticket.getUserID());
                ptm.setString(2, ticket.getBookItemID());
                ptm.setDate(3, ticket.getBorrowDate());
                ptm.setDate(4, ticket.getExpiredDate());
                ptm.setString(5, ticket.getBorrowStatus());
                ptm.executeQuery();
                rs = ptm.getGeneratedKeys();
                while (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return id;
    }

    public int createViolationTicket(ViolationTicketDTO ticket) throws SQLException {
        int id = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_VIOLATIONTICKET);
                ptm.setInt(1, ticket.getBookingTicketID());
                ptm.setString(2, ticket.getDescription());
                ptm.setString(3, ticket.getTicketStatus());
                ptm.setString(4, ticket.getStaffID());
                ptm.executeQuery();
                rs = ptm.getGeneratedKeys();
                while (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return id;
    }

    public boolean returnBook(Date returnDate, String bookingTicketID) throws SQLException {
        boolean check = false;
        boolean check1 = false;
        boolean check2 = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(RETURNBOOK);
                ptm.setDate(1, returnDate);
                ptm.setString(2, "Da Tra");
                ptm.setString(3, bookingTicketID);
                check1 = ptm.executeUpdate() > 0 ? true : false;
                ptm = conn.prepareStatement(UPDATEBOOKITEMSTATUS);
                ptm.setString(1, "On Bookshelf");
                ptm.setString(2, bookingTicketID);
                check2 = ptm.executeUpdate() > 0 ? true : false;
            }
            check = check1 && check2;
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean confirmBookingTicket(String bookingTicketID) throws SQLException {
        boolean check = false;
        boolean check1 = false;
        boolean check2 = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CONFIRMBOOKINGTICKET);
                ptm.setString(1, "Dang Muon");
                ptm.setString(2, bookingTicketID);
                check1 = ptm.executeUpdate() > 0 ? true : false;
                ptm = conn.prepareStatement(UPDATEBOOKITEMSTATUS);
                ptm.setString(1, "Da Duoc Muon");
                ptm.setString(2, bookingTicketID);
                check2 = ptm.executeUpdate() > 0 ? true : false;
            }
            check = check1 && check2;
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean updateViolationStatus(String ticketStatus, String violationTicketID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATEVIOLATIONSTATUS);
                ptm.setString(1, ticketStatus);
                ptm.setString(2, violationTicketID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
