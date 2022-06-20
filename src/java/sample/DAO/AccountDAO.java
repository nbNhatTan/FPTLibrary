/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.DTO.AccountDTO;
import sample.Utils.DBUtils;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    private static final String LOGIN = "SELECT accountID, fullName, roleID, email, address, phone, status FROM tblAccounts WHERE accountID=? AND password=?";
    private static final String SEARCH = "SELECT accountID, fullName, roleID, email, address, phone, status FROM tblAccounts WHERE fullName like ?";
    private static final String DELETE = "UPDATE tblAccounts SET status='false' WHERE accountID=?";
    private static final String UPDATE = "UPDATE tblAccounts SET fullName=?, password=?, email=?, address=?, phone=? WHERE accountID=?";
    private static final String CHECK_DUPLICATE = "SELECT accountID FROM tblAccounts WHERE accountID=?";
    private static final String CREATE = "INSERT INTO tblAccounts(accountID, fullName, password, roleID, email, address, phone, status) VALUES (?,?,?,?,?,?,?,?)";

    public AccountDTO checkLogin(String accountID, String password) throws SQLException {
        AccountDTO acc = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, accountID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    int roleID = rs.getInt("roleID");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    Boolean status = rs.getBoolean("status");
                    acc = new AccountDTO(accountID, fullName, "", roleID, email, address, phone, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return acc;
    }

    public List<AccountDTO> getListAccount(String search) throws SQLException {
        List<AccountDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String accountID = rs.getString("accountID");
                    String fullName = rs.getString("fullName");
                    int roleID = rs.getInt("roleID");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    Boolean status = rs.getBoolean("status");
                    list.add(new AccountDTO(accountID, fullName, "", roleID, email, address, phone, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean deleteAccount(String accountID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, accountID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean updateUser(AccountDTO acc) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, acc.getFullName());
                ptm.setString(2, acc.getPassword());
                ptm.setString(3, acc.getEmail());
                ptm.setString(4, acc.getAddress());
                ptm.setString(5, acc.getPhone());
                ptm.setString(6, acc.getAccountID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(String accountID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, accountID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean create(AccountDTO acc) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, acc.getAccountID());
                ptm.setString(2, acc.getFullName());
                ptm.setString(3, acc.getPassword());
                ptm.setInt(4, acc.getRoleID());
                ptm.setString(5, acc.getEmail());
                ptm.setString(6, acc.getAddress());
                ptm.setString(7, acc.getPhone());
                ptm.setBoolean(8, acc.getStatus());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
