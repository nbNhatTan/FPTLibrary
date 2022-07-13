/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DTO;

import sample.DAO.*;

/**
 *
 * @author anhkhoa
 */
public class FeedBackDTO {
    private String feedbackID;
    private String userID;
    private int bookID;
    private String comment;

    public FeedBackDTO(String feedbackID, String userID, int bookID, String comment) {
        this.feedbackID = feedbackID;
        this.userID = userID;
        this.bookID = bookID;
        this.comment = comment;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
    
}
