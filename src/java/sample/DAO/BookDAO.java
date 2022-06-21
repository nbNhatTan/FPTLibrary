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
import sample.DTO.NewsDTO;
import sample.DTO.PackageDTO;
import sample.Utils.DBUtils;

/**
 *
 * @author NhatTan
 */
public class BookDAO {

    private static final String CREATE_BOOK = "INSERT INTO tblBook(bookName, quantity, bookshelf, languageID, [description], DDC, authorID, publisherID, publishYear, [image]) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String CREATE_PACKAGE = "INSERT INTO tblPackage(PackageName, price, importDate) VALUES (?,?,?)";
    private static final String CREATE_BOOKITEM = "INSERT INTO tblBookItem(bookItemID, bookID, bookStatus, packageID) VALUES (?,?,?,?)";
    private static final String SEARCH = "SELECT bookID, bookName, bookshelf, [image], [description], DDC, l.languageName, a.authorName, p.publisherName, publishYear FROM tblBook b JOIN tblLanguages l ON b.languageID = l.languageID JOIN tblAuthors a ON b.authorID = a.authorID JOIN tblPublishers p ON b.publisherID = p.publisherID WHERE bookName like ?";
    private static final String GETLIST_PACKAGE = "SELECT packageName, price, importDate FROM tblPackage";
    private static final String GETLIST_BOOKITEM = "SELECT bookItemID, bookID, bookStatus, packageID FROM tblBookItem";
    private static final String UPDATE_BOOKITEM = "UPDATE tblBookItem SET bookStatus=? WHERE bookItemID=? ";
    private static final String COUNT = "SELECT COUNT bookItemID FROM tblBookItem WHERE bookID = ?";
    private static final String GETBOOKBYID = "SELECT bookName, bookshelf, [image], [description], DDC, l.languageName, a.authorName, p.publisherName, publishYear FROM tblBook b JOIN tblLanguages l ON b.languageID = l.languageID JOIN tblAuthors a ON b.authorID = a.authorID JOIN tblPublishers p ON b.publisherID = p.publisherID where bookID=?";
    private static final String CREATE_TABLE = "INSERT INTO ?(?) VALUES (?)";
    private static final String GETTOP5BOOK = "SELECT TOP(5) bookID, bookName, [image] FROM tblBook ORDER BY bookID DESC";
    private static final String GETTOPNEWS = "SELECT TOP(10) newsID, title, uploadDate FROM tblNews ORDER BY newsID DESC";
    private static final String GETNEWS = "SELECT TOP 1 * FROM tblNews ORDER BY newsID DESC";

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
                ptm.setInt(6, findInformationID(book.getLanguage(), "Language"));
                ptm.setInt(7, findInformationID(book.getAuthor(), "Author"));
                ptm.setInt(8, findInformationID(book.getPublisher(), "Publisher"));
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
                    int bookID = rs.getInt("bookID");
                    String bookName = rs.getString("bookName");
                    String bookshelf = rs.getString("bookshelf");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    String DDC = rs.getString("DDC");
                    String language = rs.getString("languageName");
                    String author = rs.getString("authorName");
                    String publisher = rs.getString("publisherName");
                    String publishYear = rs.getString("publishYear");
                    BookDTO book = new BookDTO(bookName, 0, bookshelf, description, DDC, language, author, publisher, publishYear, image);
                    book.setBookID(bookID);
                    list.add(book);
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

    public BookDTO getProductByID(int bookID) throws SQLException {
        BookDTO book;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETBOOKBYID);
                ptm.setInt(1, bookID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String bookName = rs.getString("bookName");
                    String bookshelf = rs.getString("bookshelf");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    String DDC = rs.getString("DDC");
                    String language = rs.getString("languageName");
                    String author = rs.getString("authorName");
                    String publisher = rs.getString("publisherName");
                    String publishYear = rs.getString("publishYear");
                    book = new BookDTO(bookName, 0, bookshelf, description, DDC, language, author, publisher, publishYear, image);
                    book.setBookID(bookID);
                    return book;
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
        return null;
    }

    public int findInformationID(String name, String infor) throws SQLException {
        int id = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_BOOK);
                ptm.setString(1, name);
                String table = "tbl" + infor + "s";
                ptm.setString(2, table);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt(1);
                } else {
                    ptm = conn.prepareStatement(CREATE_TABLE);
                    ptm.setString(1, table);
                    table = infor.toLowerCase() + "Name";
                    ptm.setString(1, table);
                    ptm.setString(1, name);
                    ptm.executeQuery();
                    rs = ptm.getGeneratedKeys();
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
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

    public List<BookDTO> getTop5Book() throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETTOP5BOOK);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int bookID = rs.getInt("bookID");
                    String bookName = rs.getString("bookName");
                    String image = rs.getString("image");
                    BookDTO book = new BookDTO(bookName, 0, "", "", "", "", "", "", "", image);
                    book.setBookID(bookID);
                    list.add(book);
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

    public List<NewsDTO> getTopNews() throws SQLException {
        List<NewsDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETTOPNEWS);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int newsID = rs.getInt("newsID");
                    String title = rs.getString("title");
                    Date uploadDate = rs.getDate("uploadDate");
                    NewsDTO news = new NewsDTO(newsID, "", title, "", "", "", uploadDate);
                    news.setNewsID(newsID);
                    list.add(news);
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

    public NewsDTO getNews() throws SQLException {
        NewsDTO news = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETNEWS);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int newsID = rs.getInt("newsID");
                    String writeName = rs.getString("writerName");
                    String title = rs.getString("title");
                    String head = rs.getString("head");
                    String body = rs.getString("body");
                    String staffID = rs.getString("staffID");
                    Date uploadDate = rs.getDate("uploadDate");
                    news = new NewsDTO(newsID, writeName, title, head, body, staffID, uploadDate);
                    news.setNewsID(newsID);
                    return news;
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
        return null;
    }
       // Advance Search: 
    private static final String ADVANCE_SEARCH = "SELECT bookID, bookName, bookshelf, [image], [description], "
            + "DDC, l.languageName, a.authorName, p.publisherName, publishYear FROM tblBook b JOIN tblLanguages l "
            + "ON b.languageID = l.languageID JOIN tblAuthors a "
            + "ON b.authorID = a.authorID JOIN tblPublishers p "
            + "ON b.publisherID = p.publisherID "
            + "WHERE bookName like ? AND a.authorName like ? AND p.publisherName like ? AND l.languageName like ?";
    public List<BookDTO> getListBook(String bBookName, String bAuthor, String bPublisher, String bLanguage) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADVANCE_SEARCH);
                ptm.setString(1, "%" + bBookName + "%");
                ptm.setString(2, "%" + bAuthor + "%");
                ptm.setString(3, "%" + bPublisher + "%");
                ptm.setString(4, "%" + bLanguage + "%");
                rs = ptm.executeQuery();
                System.out.print(ADVANCE_SEARCH);
                while (rs.next()) {
                    int bookID = rs.getInt("bookID");
                    String bookName = rs.getString("bookName");
                    String bookshelf = rs.getString("bookshelf");
                    String image = rs.getString("image");
                    String description = rs.getString("description");
                    String DDC = rs.getString("DDC");
                    String language = rs.getString("languageName");
                    String author = rs.getString("authorName");
                    String publisher = rs.getString("publisherName");
                    String publishYear = rs.getString("publishYear");
                    BookDTO book = new BookDTO(bookName, 0, bookshelf, description, DDC, language, author, publisher, publishYear, image);
                    book.setBookID(bookID);
                    list.add(book);
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
    
}
