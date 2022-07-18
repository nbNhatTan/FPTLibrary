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
            
    
        private static final String CREATE_FEEDBACK = "INSERT INTO tblFeedback(feedbackID, userID, bookID , comment, star) VALUES (?,?,?,?,?)";
        private static final String VIEW_FEEDBACK = "SELECT FeedbackID , bookID, userID, comment , star FROM tblFeedback WHERE bookID = ?  ";
        private static final String CHECK_DUPLICATE = "SELECT userID from tblFeedback WHERE feedbackID = ?" ;
    
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
                ptm.setString(2, feedback.getUserID());
                ptm.setInt(3, feedback.getBookID());
                ptm.setString(4, feedback.getComment());
                ptm.setInt(5, feedback.getStar());
                    
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
        
     public List<FeedBackDTO> getFeedbackList(int bookID) throws SQLException, ClassNotFoundException {
        List<FeedBackDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_FEEDBACK);
                ptm.setInt(1, bookID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String feedbackID = rs.getString("feedbackID");                                       
                    String userID = rs.getString("userID");
                    String comment = rs.getString("comment");
                    int star = rs.getInt("star");
                    list.add(new FeedBackDTO(feedbackID,userID, bookID,comment,star));
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
        
        
     
     public boolean checkDuplicate(String feedbackID ) throws SQLException{
        boolean check = false;
        Connection conn= null;
        PreparedStatement ptm =null;
        ResultSet rs =null;
        try{
            conn= DBUtils.getConnection();
                    if(conn!= null){
                        ptm = conn.prepareStatement(CHECK_DUPLICATE);
                        ptm.setString(1, feedbackID);      
                        rs = ptm.executeQuery();
                        if(rs.next()){
                            check = true;
                        }
                    }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();           
        }
        return check;
    }
     
     
}
