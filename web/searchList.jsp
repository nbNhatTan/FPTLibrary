<%-- 
    Document   : SearchList
    Created on : Jun 12, 2022, 8:28:46 PM
    Author     : bachds
--%>

<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DAO.BookDAO"%>
<%@page import="java.util.List"%>
<%@page import="sample.DTO.BookDTO"%>
<%@page import="sample.DTO.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/searchList.css">
        <link rel="stylesheet" href="CSS/style1.css">
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Thư viện FPTU HCM</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
              rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />


    </head>

    <body>
       <jsp:include page="header.jsp"></jsp:include>


        <div class="main">
            <div class="body-page row">
                <div class="col-md-1"></div>
                <div class="container col-md-10 content">
                    <div class="title-result">
                        <h3>
                            Result
                        </h3>
                    </div>

                    <div class="wrapper">

                        <div class="wrapper-column-1">
                            <%
                                List<BookDTO> list = (List<BookDTO>) request.getAttribute("LIST_BOOK");
                                if (list != null) {
                                    if (list.size() > 0) {
                            %>
                            <form action="MainController">
                                <div class="all-books"> 
                                    <%
                                        for (BookDTO book : list) {
                                    %>

                                    <div class="book">
                                        <a href="MainController?action=Detail&bookID=<%=book.getBookID()%>">
                                            <img src="<%= book.getImage()%>" width="180" height="260"> 
                                            <h3>
                                                <%= book.getBookName()%>
                                            </h3>
                                        </a>
                                    </div>

                                    <%
                                        }
                                    %>

                                </div>
                            </form>
                            <%
                                    }
                                }
                            %>
                        </div>

                        <div class="wrapper-column-2">

                        </div>
                    </div>
                    <div class="all-button-pages">
                        <button>
                            <i class="fa-solid fa-arrow-left"></i>
                        </button>
                        <button>1</button>
                        <button>2</button>
                        <button>3</button>
                        <button>4</button>
                        <button>...</button>
                        <button>7</button>
                        <button>8</button>
                        <button>9</button>
                        <button>10</button>
                        <button>
                            <i class="fa-solid fa-arrow-right"></i>
                        </button>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>


        <jsp:include page="footer.jsp"></jsp:include>

    </body>

</html>
