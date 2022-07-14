<%-- 
    Document   : advanceSearch
    Created on : Jun 16, 2022, 11:25:37 AM
    Author     : bachds
--%>

<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.DTO.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Advanced Search</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
              rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="CSS/style1.css" />
        <link rel="stylesheet" href="CSS/advanceSearch.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <%
            AccountDTO acc = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (acc == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            if (acc.getRoleID() != 3) {
                response.sendRedirect("error.jsp");
                return;
            }

        %>
        <div class="main">
            <div class="row contents">
                <div class="col-md-1"></div>
                <div class="col-md-10 contents">
                    <div class="content">

                        <form action="MainController" method="POST">

                            <table class="my-table container-fluid">
                                <%
                                    String bookName = (String) request.getAttribute("bookName");
                                    String publisher = (String) request.getAttribute("publisher");
                                    String author = (String) request.getAttribute("author");
                                    String language = (String) request.getAttribute("language");
                                    String categoryId = (String) request.getAttribute("categoryId");
                                    if(bookName == null) bookName = "";
                                    if(publisher == null) publisher = "";
                                    if(author == null) author = "";
                                    if(language == null) language = "";
                                    if(categoryId == null) categoryId = "";
                                %>
                                <tr>
                                    <td><label for="">Book Name:</label></td>
                                    <td><input type="text" name="bookName" placeholder="can be blank..." value="<%=bookName%>"></td>
                                </tr>

                                <tr>
                                    <td><label for="">Publisher:</label></td>
                                    <td><input type="text" name="publisher" placeholder="can be blank..." value="<%=publisher%>"></td>
                                </tr>
                                <tr>
                                    <td><label for="">Author:</label></td>
                                    <td><input type="text" name="author" placeholder="can be blank..." value="<%=author%>"></td>
                                </tr>
                                <tr>
                                    <td><label for="">Language:</label></td>
                                    <td><input type="text" name="language" placeholder="can be blank..." value="<%=language%>"></td>
                                </tr>
                                <tr>
                                    <td><label for="">&nbsp;</label></td>
                                    <input  type="hidden" name="categoryId" value="<%=categoryId%>"/>
                                </tr>
                                <tr>
                                    <td><label for="">BookTag:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td class="list-unstyled">
                                        <li>
                                        <%
                                            List<CategoryDTO> listCategory = (List<CategoryDTO>) request.getAttribute("LIST_CATEGORY");
                                            if (listCategory != null) {
                                                for (CategoryDTO c : listCategory) {
                                        %>
                                        <a href="MainController?action=AdvanceSearch&categoryId=<%=c.getCategoryID()%>" style="font-size: 12px; background: #F3F3F3; border: 1px solid #E8E8E8;
                                            display: inline-block; color: #000; padding: 2px 5px; text-align: center;"><%=c.getCategoryName()%>
                                        </a>
                                        <%
                                                }
                                            }
                                        %>
                                        </li>
                                    </td>
                                </tr>

                            </table>
                            <div class="">
                                <div class="padding">

                                    <input class="btn btn-warning btn-sm" type="submit" name="action" value="AdvanceSearch" />
                                    <a href="LoadAdvancedSearchController"><button class="btn btn-warning btn-sm" type="button">reset</button></a>
                                </div>

                            </div>
                        </form>
                    </div>
                <div class="table-container content">
                    <%
                        List<BookDTO> list = (List<BookDTO>) request.getAttribute("ADVANCE_LIST_BOOK");
                        if (list != null) {
                            if (!list.isEmpty()) {
                    %>
                    <h1 class="heading"> List result</h1>
                    <table class="tableStyle book">
                        <thead>
                            <tr>
                                <th>Number</th>
                                <th>Image</th>
                                <th>Book</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int count = 0;
                                for (BookDTO book : list) {
                                    count++;
                            %>
                            <tr class="tb">
                                <td class="tb"><%= count%></td>
                                <td class="tb"><a href="MainController?action=Detail&bookID=<%=book.getBookID()%>"><img src="<%= book.getImage()%>" /></a></td>
                                <td class="tb">
                                    <div class="noBorder">
                                        <table>
                                            <tr>
                                                <td>Name:</td>
                                                <td>
                                                    <a href="MainController?action=Detail&bookID=<%=book.getBookID()%>">
                                                        <%= book.getBookName()%>
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Author:</td>
                                                <td>
                                                    <%= book.getAuthor()%>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Publisher:</td>
                                                <td>
                                                    <%= book.getPublisher()%>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Publish Year:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                <td><%= book.getPublishYear()%></td>
                                            </tr>
                                            <tr>
                                                <td>Language:</td>
                                                <td><%= book.getLanguage()%></td>
                                            </tr>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>

    </div>

    <jsp:include page="footer.jsp"></jsp:include>
    <%
        if (request.getAttribute("message") != null) {
    %>
    <script> window.alert("No result!");</script>
    <%
        }
    %>
</body>
</html>
