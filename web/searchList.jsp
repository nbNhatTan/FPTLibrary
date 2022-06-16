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
        <link rel="stylesheet" href="searchList.css">
        <link rel="stylesheet" href="style1.css">
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
        <%
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <nav class="navbar navbar-expand-md navbar-light">
            <div class="container-fluid padding">
                <div class="col-md-5">
                    <div class="p-2">
                        <a class="navbar-branch" href="HomePageFPTU.jsp">
                            <img
                                class="img"
                                src="https://cdn.glitch.global/b5568004-6653-447c-bb6a-cd2cd0c89e38/LogoFPT.png?v=1653532923912"
                                width="325"
                                height="71"
                                />
                        </a>
                    </div>
                </div>
                <div class="col-md-6">
                    <form action="MainController">
                        <input type="text" name="search" placeholder="Search" value=<%=search%>>
                        <button class="btn btn-warning btn-sm" type="submit" name="action" value="SearchBook">Search</button>
                    </form>
                </div>
                <%
                    AccountDTO acc = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
                    if (acc != null) {
                %>
                <div class="col-md-2 col">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <h5><a class="nav-link" href="#">Hello <%=acc.getFullName()%></a></h5>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="LogoutController">Logout</a>
                        </li>
                    </ul>
                </div>
                <%
                } else {
                %>
                <div class="col-md-1 col">
                    <a class="btn btn-warning btn-sm user" href="login.html"> LOGIN </a>
                </div>
                <%
                    }
                %>
            </div>
        </nav>

        <nav class="nav navbar-expand-md navbar-light sticky-top">
            <div>
                <button class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="HomeController">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdvancedSearch.html">Advanced Search</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ViewborrowController">Borrow List</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Following</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


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
                                            <img src="<%= book.getImage()%>"> 
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


        <footer class="text-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-lg-4 col-xl-3">
                        <h5>About</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25" />
                        <p class="mb-0">Project SWP SU2022</p>
                    </div>

                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                        <h5>Informations</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25" />
                        <ul class="list-unstyled">
                            <li><a href="">Facebook</a></li>
                            <li><a href="">Instagram</a></li>
                            <li><a href="">GiHub</a></li>
                            <li><a href="">Youtube</a></li>
                        </ul>
                    </div>

                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto"></div>

                    <div class="col-md-4 col-lg-3 col-xl-3">
                        <h5>Contact</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25" />
                        <ul class="list-unstyled">
                            <li><i class="fa fa-home mr-2"></i> FPT Uni</li>
                            <li><i class="fa fa-envelope mr-2"></i>library@gmail.com</li>
                            <li><i class="fa fa-phone mr-2"></i> + 84 877660374</li>
                            <li><i class="fa fa-print mr-2"></i></li>
                        </ul>
                    </div>
                    <div class="col-12 copyright mt-3">
                        <p class="float-left">
                            <a href="#">Back to top</a>
                        </p>
                    </div>
                </div>
            </div>
        </footer>

    </body>

</html>
