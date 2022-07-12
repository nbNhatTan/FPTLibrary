/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sample.DTO.BookDTO;
import sample.DTO.FeedBackDTO;
import sample.Utils.DBUtils;

/**
 *
 * @author anhkhoa
 */
public class FeedbackDAO {
            
    
        private static final String CREATE_FEEDBACK = "INSERT INTO tblFeedback(feedbackID, userID, bookingTicketID , comment, VALUES (?,?,?,?)";
        private static final String VIEW_FEEDBACK = "SELECT FeedbackID , bookingTicketID, userID, comment  FROM tblFeedback  ";
    
    
        public boolean createFeedback(FeedBackDTO feedback) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_FEEDBACK);
                ptm.setString(1, feedback.getFeedbackID());
                ptm.setInt(3, feedback.getBookingTicketID());
                ptm.setString(2, feedback.getUserID());               
                ptm.setString(4, feedback.getComment());
                    
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
        
     public List<FeedBackDTO> getFeedbackList(String search) throws SQLException, ClassNotFoundException {
        List<FeedBackDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_FEEDBACK);
                ptm.setString(1, "%" +search+ "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String feedbackID = rs.getString("feedbackID");
                    int bookingTicketID = rs.getInt("bookingTicketID");                     
                    String userID = rs.getString("userID");
                    String comment = rs.getString("comment");
                    list.add(new FeedBackDTO(feedbackID,userID, bookingTicketID,comment));
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
        
        
     
     
}
