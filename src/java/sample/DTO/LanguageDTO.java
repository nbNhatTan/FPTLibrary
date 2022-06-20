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
public class LanguageDTO {

    private int languageID;
    private String languageName;

    public LanguageDTO() {
    }

    public LanguageDTO(int languageID, String languageName) {
        this.languageID = languageID;
        this.languageName = languageName;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

}
