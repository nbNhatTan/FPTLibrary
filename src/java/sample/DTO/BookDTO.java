/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.DTO;

/**
 *
 * @author NhatTan
 */
public class BookDTO {

    private String bookID;
    private String bookName;
    private int Quantity;
    private String bookshelf;
    private int languageID;
    private String decription;
    private String DDC;
    private int authorID;
    private int publisherID;
    private String publisherYear;
    private String image;

    public BookDTO(String bookID, String bookName, int Quantity, String bookshelf, int languageID, String decription, String DDC, int authorID, int publisherID, String publisherYear, String image) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.Quantity = Quantity;
        this.bookshelf = bookshelf;
        this.languageID = languageID;
        this.decription = decription;
        this.DDC = DDC;
        this.authorID = authorID;
        this.publisherID = publisherID;
        this.publisherYear = publisherYear;
        this.image = image;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(String bookshelf) {
        this.bookshelf = bookshelf;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getDDC() {
        return DDC;
    }

    public void setDDC(String DDC) {
        this.DDC = DDC;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public String getPublisherYear() {
        return publisherYear;
    }

    public void setPublisherYear(String publisherYear) {
        this.publisherYear = publisherYear;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FPTLibrary.sample.DTO.Account[ id=" + bookID + " ]";
    }

}
