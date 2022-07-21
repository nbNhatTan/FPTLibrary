/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sample.DTO.NewsDTO;
import sample.Utils.DBUtils;
import sample.Utils.SecurityUtils;

/**
 *
 * @author anhkhoa
 */
public class NewsDAO {
    
    private static final String  ADD_NEWS = "INSERT INTO tblNews( writerName , title, head, body, staffID , uploadDate) VALUES (?,?,?,?,?,?)";
    private static final String  VIEW_NEWS = "SELECT newsID, writerName , title, head, body, uploadDate FROM tblNews WHERE newsID = ?";
    private static final String CHECK_DUPLICATE_NEWSID = "SELECT writerName  from tblNews WHERE newsID = ?" ;
    
    public boolean addNews(NewsDTO news) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_NEWS);
               
                ptm.setString(1, news.getWriterName());
                ptm.setString(2, news.getTitle());              
                ptm.setString(3, news.getHead());
                ptm.setString(4, news.getBody());
                ptm.setString(5, news.getAccountID());
                ptm.setDate(6, news.getUploadDate());
     
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
    
    
    
    
    public List<NewsDTO> getFeedbackList(int bookID) throws SQLException, ClassNotFoundException {
        List<NewsDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_NEWS);
                ptm.setInt(1, bookID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int newsID = rs.getInt("newsID");
                    String writerName = rs.getString("writerName");
                    String title = rs.getString("title");
                    String head = rs.getString("head");
                    String body = rs.getString("body");
                    String AccountID = rs.getString("AccountID");
                    Date uploadDate = rs.getDate("uploadDate");
                    NewsDTO news = new NewsDTO(newsID, writerName, title, head, body, AccountID, uploadDate);
                    
                    list.add(news);
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
    
     public boolean checkDuplicateNewsID(int newsID ) throws SQLException{
        boolean check = false;
        Connection conn= null;
        PreparedStatement ptm =null;
        ResultSet rs =null;
        try{
            conn= DBUtils.getConnection();
                    if(conn!= null){
                        ptm = conn.prepareStatement(CHECK_DUPLICATE_NEWSID);
                        ptm.setInt(1, newsID);      
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
