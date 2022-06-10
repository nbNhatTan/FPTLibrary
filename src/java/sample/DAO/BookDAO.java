/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.DTO.BookDTO;
import sample.DTO.BookItemDTO;
import sample.DTO.PackageDTO;
import sample.Utils.DBUtils;

/**
 *
 * @author NhatTan
 */
public class BookDAO {

    private static final String CREATE_BOOK = "INSERT INTO tblBook(bookName, quantity, bookshelf, languageID, description, DDC, authorID, publisherID, publishYear, image) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String CREATE_PACKAGE = "INSERT INTO tblPackage(PackageName, price, importDate) VALUES (?,?,?)";
    private static final String CREATE_BOOKITEM = "INSERT INTO tblBookItem(bookItemID, bookID, bookStatus, packageID) VALUES (?,?,?,?)";
    private static final String SEARCH = "SELECT bookName, quantity, bookshelf, description, DDC, languageID, authorID, publisherID, publishYear, image FROM tblBook WHERE ? like %?%";
    private static final String GETLIST_PACKAGE = "SELECT packageName, price, importDate FROM tblPackage";
    private static final String GETLIST_BOOKITEM = "SELECT bookItemID, bookID, bookStatus, packageID FROM tblBookItem";
    private static final String UPDATE_BOOKITEM = "UPDATE tblBookItem SET bookStatus=? WHERE bookItemID=? ";
    private static final String COUNT = "SELECT COUNT bookItemID FROM tblBookItem WHERE bookID = ?";

    public int createBook(BookDTO book) throws SQLException {
        int id = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_BOOK);
                ptm.setString(1, book.getBookName());
                ptm.setInt(2, book.getQuantity());
                ptm.setString(3, book.getBookshelf());
                ptm.setString(4, book.getDescription());
                ptm.setString(5, book.getDDC());
                ptm.setInt(6, book.getLanguageID());
                ptm.setInt(7, book.getAuthorID());
                ptm.setInt(8, book.getPublisherID());
                ptm.setString(9, book.getPublishYear());
                ptm.setString(10, book.getImage());
                ptm.executeQuery();
                rs = ptm.getGeneratedKeys();
                while (rs.next()) {
                    id = rs.getInt(1);
                }
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
        return id;
    }

    public int createPackage(PackageDTO pack) throws SQLException {
        int id = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_PACKAGE);
                ptm.setString(1, pack.getPackageName());
                ptm.setInt(2, pack.getPrice());
                ptm.setDate(3, pack.getImportDate());
                ptm.executeQuery();
                rs = ptm.getGeneratedKeys();
                while (rs.next()) {
                    id = rs.getInt(1);
                }
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
        return id;
    }

    public int createBookItem(int bookID, int packageID) throws SQLException {
        int id = 0;
        int count = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(COUNT);
                ptm.setInt(1, bookID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
                String bookItemID = bookID + "-" + count;
                ptm = conn.prepareStatement(CREATE_BOOKITEM);
                ptm.setString(1, bookItemID);
                ptm.setInt(2, bookID);
                ptm.setString(3, "In bookshelf");
                ptm.setInt(4, packageID);
                ptm.executeQuery();
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
        return id;
    }

    public List<BookDTO> getListBook(String search) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
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
                    String bookName = rs.getString("bookName");
                    int quantity = rs.getInt("quantity");
                    String bookshelf = rs.getString("bookshelf");
                    String description = rs.getString("description");
                    String DDC = rs.getString("DDC");
                    int languageID = rs.getInt("languageID");
                    int authorID = rs.getInt("authorID");
                    int publisherID = rs.getInt("publisherID");
                    String publishYear = rs.getString("publishYear");
                    String image = rs.getString("image");
                    list.add(new BookDTO(bookName, quantity, bookshelf, description, DDC, languageID, authorID, publisherID, publishYear, image));
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

    public List<PackageDTO> getListPackage() throws SQLException {
        List<PackageDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLIST_PACKAGE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String packageName = rs.getString("packageName");
                    int price = rs.getInt("price");
                    Date importDate = rs.getDate("importDate");
                    list.add(new PackageDTO(packageName, price, importDate));
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

    public List<BookItemDTO> getListBookItem() throws SQLException {
        List<BookItemDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETLIST_BOOKITEM);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String bookItemID = rs.getString("bookItemID");
                    int bookID = rs.getInt("bookID");
                    String bookStatus = rs.getString("bookStatus");
                    int packageID = rs.getInt("packageID");
                    list.add(new BookItemDTO(bookItemID, bookID, bookStatus, packageID));
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

    public boolean updateBookItem(String bookItemID, String status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_BOOKITEM);
                ptm.setString(1, status);
                ptm.setString(2, bookItemID);
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