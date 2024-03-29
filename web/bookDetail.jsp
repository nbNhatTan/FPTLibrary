<%-- 
    Document   : Detail
    Created on : Jun 14, 2022, 11:09:52 AM
    Author     : NhatTan
--%>

<%@page import="sample.DTO.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Book Detail</title>
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
                        AccountDTO accLogin = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
                        boolean check = true;
                        if(accLogin == null) {
                            check = false;
                        }
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
                                    <td><h6>Book Tag: </h6></td>
                                    <td class="list-unstyled">
                                <li>
                                    <%
                                        List<CategoryDTO> listCategory = (List<CategoryDTO>) request.getAttribute("LIST_CATEGORY");
                                        if (listCategory != null) {
                                            for (CategoryDTO c : listCategory) {
                                    %>
                                    <a href="MainController?action=AdvanceSearch&categoryId=<%=c.getCategoryID()%>" style="font-size: 12px; background: #F3F3F3; border: 1px solid #E8E8E8;
                                       display: inline-block; color: #000; padding: 2px 5px; text-align: center;"><%=c.getCategoryName()%></a>
                                    <%
                                            }
                                        }
                                    %>
                                </li>
                                </td>
                                </tr>
                            </table>                            
                            <button type="button" onclick="book()" class="bookingButton btn btn-light btn-sm">Book</button>
                            <%
                                }
                            %>
                            <button onclick="history.back()" type="button" class="btn btn-dark btn-sm">Back</button>

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
                    <hr>
                </div>


            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="introduce row">
            <div class="col-md-1"></div>
            <div class="col-md-10 contents">
                <div class="new">
                    <h6 class="text-center">More like This</h6>

                    <div class="new2 row" >
                        <div class="col-md-1"></div>
                        <%
                            List<BookDTO> list = (List<BookDTO>) session.getAttribute("TOP_BOOK");
                            if (list != null) {
                                if (!list.isEmpty()) {
                                    for (BookDTO b : list) {
                        %>
                        <div class="col-md-2 new-item text-center">
                            <a href="MainController?action=Detail&bookID=<%= b.getBookID()%>"><img src="<%= b.getImage()%>" width="188" height="230"/></a>
                            <a href="MainController?action=Detail&bookID=<%= b.getBookID()%>"><p><%= b.getBookName()%></p></a>
                        </div>
                        <%
                                    }
                                }
                            }
                        %>
                        <div class="col-md-1"></div>
                    </div>
                </div>

            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
        function book() {
            if(<%=check%>){
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You want to borrow this book",
                    icon: 'question',
                    showCancelButton: true,
                    confirmButtonColor: '#F5D98F',
                    cancelButtonColor: '#F7E5D7',
                    confirmButtonText: 'Yes, borrow it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        location.href = "MainController?action=Borrow&bookID=<%= book.getBookID()%>";
                    }
                })
            } else{
                location.href = "login.jsp";
            }
        }
    </script>

</body>
</html>

