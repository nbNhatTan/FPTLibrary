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

    private int bookID;
    private String bookName;
    private int quantity;
    private String bookshelf;
    private int languageID;
    private String description;
    private String DDC;
    private int authorID;
    private int publisherID;
    private String publishYear;
    private String image;

    public BookDTO(String bookName, int Quantity, String bookshelf, String description, String DDC, int languageID, int authorID, int publisherID, String publishYear, String image) {
        this.bookName = bookName;
        this.quantity = Quantity;
        this.bookshelf = bookshelf;
        this.description = description;
        this.DDC = DDC;
        this.languageID = languageID;
        this.authorID = authorID;
        this.publisherID = publisherID;
        this.publishYear = publishYear;
        this.image = image;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int Quantity) {
        this.quantity = Quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
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
