<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.BookDTO"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>FPTUHCM Library</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
              rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/style1.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="main">
        <div class="row news">
            <div class="col-md-1"></div>
            <div class="col-md-10 contents">
                <div class="content">
                    <%
                        BookDTO book = (BookDTO) request.getAttribute("DETAIL_BOOK");
                        if (book != null) {
                    %>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="bookDetailImage text-center container-fluid">
                                <img src="<%= book.getImage()%>"/>
                            </div>
                        </div>
                        <div class="col-md-6 container-fluid">
                            <h5><%= book.getBookName()%></h5>
                            <table width="100%">
                                <tr>
                                    <td><h6>Authors: </h6></td>
                                    <td><%= book.getAuthor()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Publisher: </h6></td>
                                    <td><%= book.getPublisher()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Publication Year: </h6></td>
                                    <td><%= book.getPublishYear()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Language: </h6></td>
                                    <td><%= book.getLanguage()%></td>
                                </tr>
                                <tr>
                                    <td><h6>DDC: </h6></td>
                                    <td><%= book.getDDC()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Bookshelf: </h6></td>
                                    <td><%= book.getBookshelf()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Description: </h6></td>
                                    <td><%= book.getDescription()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Booktag: </h6></td>
                                    <td></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>


            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="contents row">
            <div class="col-md-1"></div>
            <div class="col-md-10 contents">
                <div class="content">
                    <h6>Booking Confirm: </h6>
                    <a href="BookDetailController?bookID=<%= book.getBookID()%>"><button type="button" class="btn btn-light btn-sm">Cancel</button></a>
                    <a href="MainController?action=Borrow&bookID=<%= book.getBookID()%>"><button type="button" class="bookingButton btn btn-light btn-sm">Confirm</button></a>
                </div>
                <%
                    }
                %> 

            </div>
            <div class="col-md-1"></div>
        </div>

    </div>
    <jsp:include page="footer.jsp"></jsp:include>


</body>
</html>