<%-- 
    Document   : addBook
    Created on : Jun 16, 2022, 11:04:28 AM
    Author     : Admin
--%>

<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.BookError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Add Book</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/style.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet" />
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>


        <%
            AccountDTO acc = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (acc == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            if (acc.getRoleID() != 2) {
                response.sendRedirect("error.jsp");
                return;
            }

        %>
        <div>


            <div>

            </div>
            <h3 class="title-text">ADD BOOK</h3>
            <%                BookError bookError = (BookError) request.getAttribute("BOOK_ERROR");
                if (bookError == null) {
                    bookError = new BookError();
                }
            %>
            <form action="MainController" method="POST">

                <table class="my-table">
                    <tr>
                        <td><label for="">Book Name:</label></td>
                        <td><input name="bookName" type="text" placeholder="Enter Book Name" required=""><%= bookError.getBookNameError()%></td>
                    </tr>
                    <tr>
                        <td><label for="">Quantity:</label></td>
                        <td><input name="quantity" type="text" placeholder="Enter Quantity" required=""><%= bookError.getQuantityError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Bookshelf:</label></td>
                        <td><input name="bookshelf" type="text" placeholder="Enter Bookshelf" required=""><%= bookError.getBookshelfError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Language:</label></td>
                        <td><input name="language" type="text" placeholder="Enter Language" required=""><%= bookError.getLanguageError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Author:</label></td>
                        <td><input name="author" type="text" placeholder="Enter Author" required=""><%= bookError.getAuthorError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Publisher:</label></td>
                        <td><input name="publisher" type="text" placeholder="Enter Publisher" required=""><%= bookError.getPublisherError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Description:</label></td>
                        <td><input name="description" type="text" placeholder="Enter Description" required=""><%= bookError.getDescriptionError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">DDC:</label></td>
                        <td><input name="DDC" type="text" placeholder="Enter DDC" required=""><%= bookError.getDDCError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Publish Year:</label></td>
                        <td><input name="publishYear" type="text" placeholder="Enter Publish Year" required=""><%= bookError.getPublishYearError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Image:</label></td>
                        <td><input name="image" type="text" placeholder="Enter Image" required=""><%= bookError.getImageError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Package Name:</label></td>
                        <td><input name="packageName" type="text" placeholder="Enter Package Name" required=""><%= bookError.getPackageNameError()%></td>                            
                    </tr>
                    <tr>
                        <td><label for="">Price:</label></td>
                        <td><input name="price" type="text" placeholder="Enter Price" required=""><%= bookError.getPriceError()%></td>                            
                    </tr>
                    <tr>
                        <td></td>
                        <td class="a"><button class="btn btn-warning btn-sm" type="submit" name="action" value="AddBook">Add Book</button></td>

                    </tr>

                </table>
            </form>

        </div>
    </div>


    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
