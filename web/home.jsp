<%-- 
    Document   : Home.jsp
    Created on : Jun 16, 2022, 1:43:06 AM
    Author     : NhatTan
--%>

<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.NewsDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.DTO.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Thư viện FPTU HCM</title>
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
            />
        <link
            href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
            rel="stylesheet"
            />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/style1.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="main">
                <div class="row news">
                    <div class="col-md-1"></div>
                        <div class="col-md-10 contents">

                            <div class="new row">
                                <div class="col-md-1"></div>
                                <%
                                    List<BookDTO> list = (List<BookDTO>) session.getAttribute("TOP_BOOK");
                                    if (list != null) {
                                        if (list.size() > 0) {
                                            for (BookDTO p : list) {
                                %>
                                    <div class="col-md-2 new-item text-center">
                                        <img src="<%=p.getImage()%>"
                                             width="230"
                                             height="230" />
                                        <p><a href="MainController?action=Detail&bookID=<%=p.getBookID()%>"><%=p.getBookName()%></a></p>
                                    </div>                            
                                <%
                                            }
                                        }
                                    }
                                %>
                                <div class="col-md-1"></div>
                            </div>

                        </div>
                    <div class="col-md-1"></div>
                </div>
            <hr height="100">
            <div class="contents row">
                <div class="col-md-1"></div>
                <div class="col-md-10 contents">
                    <div class="content row">
                        <div class="contents col-md-8">
                            <%
                                NewsDTO news = (NewsDTO) request.getAttribute("NEWS");
                                if (news != null) {
                            %>
                            <div class="main-content">
                                <h1><%=news.getTitle()%></h1>                                    
                                <h4><i><%=news.getWriterName()%><i></h4>                                    
                                <h6><i>Staff: <%=news.getAccountID()%></i></h6>                                    
                                <h6><i>Date: <%=news.getUploadDate()%></i></h6>
                                <br>
                                <p><%=news.getHead()%></p>
                                <p><%=news.getBody()%></p>
                            </div>
                            <%
                                }
                            %> 
                        </div> 
                    <div class="vertical-line"></div>
                    <div class="contents col-md-4">
                        <%
                            List<NewsDTO> listN = (List<NewsDTO>) request.getAttribute("TOP_NEWS");
                            if (listN != null) {
                                if (listN.size() > 0) {
                                    for (NewsDTO n : listN) {
                        %>
                        <div >
                            <h6><a href=""><%= n.getTitle()%></a></h6>
                        </div>
                        <%
                                    }
                                }
                            }
                        %>
                                            </div>
                                            </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>

     <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>