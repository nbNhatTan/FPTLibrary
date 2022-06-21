<%-- 
    Document   : advanceSearch
    Created on : Jun 16, 2022, 11:25:37 AM
    Author     : bachds
--%>

<%@page import="java.util.List"%>
<%@page import="sample.DTO.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    
    <head>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Thư viện FPTU HCM</title>
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
    <div class="main">
        <div class="row contents">
            <div class="col-md-1"></div>
            <div class="col-md-10 contents">
                <div class="content">

                    <form action="MainController" method="POST">

                        <table class="my-table container-fluid">
                            <tr>
                                <td><label for="">Book Name:</label></td>
                                <td><input type="text" name="bookName" placeholder="can be blank..."></td>
                            </tr>

                            <tr>
                                <td><label for="">Publisher</label></td>
                                <td><input type="text" name="publisher" placeholder="can be blank..."></td>
                            </tr>
                            <tr>
                                <td><label for="">Author</label></td>
                                <td><input type="text" name="author" placeholder="can be blank..."></td>
                            </tr>
                            <tr>
                                <td><label for="">Language</label></td>
                                <td><input type="text" name="language" placeholder="can be blank..."></td>
                            </tr>


                        </table>
                        <div class="">
                            <div class="padding">

                                <input class="btn btn-warning btn-sm" type="submit" name="action" value="AdvanceSearch" />

                                <button class="btn btn-warning btn-sm" type="reset">reset</button>
                            </div>

                        </div>
                    </form>
                </div>
                <%
                    List<BookDTO> list = (List<BookDTO>) request.getAttribute("ADVANCE_LIST_BOOK");
                    if (list != null) {
                        if (!list.isEmpty()) {
                            int count = 0;
                %>
                <div class="table-container content">
                    <h1 class="heading"> Danh sách kết quả</h1>
                    <table class="tableStyle book">
                        <thead>
                            <tr>
                                <th>Số thứ tự</th>
                                <th>Bìa sách</th>
                                <th>Nội dung</th>


                            </tr>
                        </thead>
                        <tbody>

                            <%
                                for (BookDTO book : list) {
                                    count++;
                            %>
                            <tr class="tb">
                                <td class="tb" data-lable="Số thứ tự"><%= count%></td>
                                <td class="tb" data-lable="Bìa sách"><a href="MainController?action=Detail&bookID=<%=book.getBookID()%>"><img src="<%= book.getImage()%>" /></a></td>
                                <td class="tb" data-lable="Nội dung">
                                    <div class="noBorder">
                                        <table width="100%">
                                            <tr>
                                                <td>Tên sách: </td>
                                                <td>
                                                    <a href="MainController?action=Detail&bookID=<%=book.getBookID()%>">
                                                    <%= book.getBookName()%>
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Tác giả:</td>
                                                <td>
                                                    <%= book.getPublisher()%>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Nhà xuất bản:</td>
                                                <td><%= book.getPublishYear()%></td>
                                            </tr>
                                            <tr>
                                                <td>Ngôn ngữ: </td>
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

                </div>
                <%
                        }
                    }
                %>


            </div>
            <div class="col-md-1"></div>
        </div>

    </div>
   
<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
