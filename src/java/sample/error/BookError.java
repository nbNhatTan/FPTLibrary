/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Error;

/**
 *
 * @author Admin
 */
public class BookError {

    private String bookIDError;
    private String bookNameError;
    private String quantityError;
    private String bookshelfError;
    private String languageError;
    private String descriptionError;
    private String DDCError;
    private String authorError;
    private String publisherError;
    private String publishYearError;
    private String imageError;

    public BookError() {
        bookIDError = "";
        bookNameError = "";
        quantityError = "";
        bookshelfError = "";
        languageError = "";
        descriptionError = "";
        DDCError = "";
        authorError = "";
        publisherError = "";
        publishYearError = "";
        imageError = "";
    }

    public BookError(String bookIDError, String bookNameError, String quantityError, String bookshelfError, String languageError, String descriptionError, String DDCError, String authorError, String publisherError, String publishYearError, String imageError) {
        this.bookIDError = bookIDError;
        this.bookNameError = bookNameError;
        this.quantityError = quantityError;
        this.bookshelfError = bookshelfError;
        this.languageError = languageError;
        this.descriptionError = descriptionError;
        this.DDCError = DDCError;
        this.authorError = authorError;
        this.publisherError = publisherError;
        this.publishYearError = publishYearError;
        this.imageError = imageError;
    }

    public String getBookIDError() {
        return bookIDError;
    }

    public void setBookIDError(String bookIDError) {
        this.bookIDError = bookIDError;
    }

    public String getBookNameError() {
        return bookNameError;
    }

    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getBookshelfError() {
        return bookshelfError;
    }

    public void setBookshelfError(String bookshelfError) {
        this.bookshelfError = bookshelfError;
    }

    public String getLanguageError() {
        return languageError;
    }

    public void setLanguageError(String languageError) {
        this.languageError = languageError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getDDCError() {
        return DDCError;
    }

    public void setDDCError(String DDCError) {
        this.DDCError = DDCError;
    }

    public String getAuthorError() {
        return authorError;
    }

    public void setAuthorError(String authorError) {
        this.authorError = authorError;
    }

    public String getPublisherError() {
        return publisherError;
    }

    public void setPublisherError(String publisherError) {
        this.publisherError = publisherError;
    }

    public String getPublishYearError() {
        return publishYearError;
    }

    public void setPublishYearError(String publishYearError) {
        this.publishYearError = publishYearError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

}
