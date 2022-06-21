
<%@page import="sample.DTO.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                        <a class="navbar-branch" href="HomeController">
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
                    <a class="btn btn-warning btn-sm user" href="login.jsp"> LOGIN </a>
                </div>
                <%
                    }
                %>
            </div>
        </nav>

        <nav class="nav navbar-expand-md navbar-light sticky-top">
            <div>
                <button
                    class="navbar-toggler"
                    type="button"
                    data-toggle="collapse"
                    data-target="#navbarResponsive"
                    >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link active" href="HomeController">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.jsp">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="advancedSearch.jsp">Advanced Search</a>
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