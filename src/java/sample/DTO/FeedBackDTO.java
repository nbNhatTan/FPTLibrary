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
    private int star;

    public FeedBackDTO(String feedbackID, String userID, int bookID, String comment, int star) {
        this.feedbackID = feedbackID;
        this.userID = userID;
        this.bookID = bookID;
        this.comment = comment;
        this.star = star;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

}
