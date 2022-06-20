/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DTO;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class NewsDTO {

    private String newsID;
    private String writerName;
    private String title;
    private String head;
    private String Body;
    private String AccountID;
    private Date uploadDate;

    public NewsDTO() {
    }

    public NewsDTO(String newsID, String writerName, String title, String head, String Body, String AccountID, Date uploadDate) {
        this.newsID = newsID;
        this.writerName = writerName;
        this.title = title;
        this.head = head;
        this.Body = Body;
        this.AccountID = AccountID;
        this.uploadDate = uploadDate;
    }

    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "FPTLibrary.sample.DTO.Account[ id=" + newsID + " ]";
    }

}
