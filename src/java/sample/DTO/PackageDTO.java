/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.DTO;

import java.sql.Date;

/**
 *
 * @author NhatTan
 */
public class PackageDTO {

    private String packageID;
    private String packageName;
    private int price;
    private Date importDate;

    public PackageDTO(String packageID, String packageName, int price, Date importDate) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.price = price;
        this.importDate = importDate;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

}
