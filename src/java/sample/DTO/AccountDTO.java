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
public class AccountDTO {

    private String accountID;
    private String fullName;
    private String password;
    private int roleID;
    private String email;
    private String address;
    private String phone;
    private Boolean status;

    public AccountDTO() {
    }

    public AccountDTO(String accountID, String fullName, String password, int roleID, String email, String address, String phone, Boolean status) {
        this.accountID = accountID;
        this.fullName = fullName;
        this.password = password;
        this.roleID = roleID;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FPTLibrary.sample.DTO.Account[ id=" + accountID + " ]";
    }

}
