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
public class PublisherDTO {

    private int publisherID;
    private String publisherName;
    private String address;

    public PublisherDTO() {
    }

    public PublisherDTO(int publisherID, String publisherName, String address) {
        this.publisherID = publisherID;
        this.publisherName = publisherName;
        this.address = address;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
