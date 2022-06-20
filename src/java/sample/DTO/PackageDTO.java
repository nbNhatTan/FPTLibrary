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
public class PackageDTO {

    private int packageID;
    private String packageName;
    private int price;
    private Date importDate;

    public PackageDTO() {
    }

    public PackageDTO(int packageID, String packageName, int price, Date importDate) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.price = price;
        this.importDate = importDate;
    }

    public PackageDTO(String packageName, int price, Date importDate) {
        this.packageName = packageName;
        this.price = price;
        this.importDate = importDate;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
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
