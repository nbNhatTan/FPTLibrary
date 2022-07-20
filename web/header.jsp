
<%@page import="sample.DTO.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String search = request.getParameter("search");
    if (search == null) {
        search = "";
    }
%>
<div class="header">
<nav class="navbar navbar-expand-md navbar-light">
    <div class="container-fluid padding row">
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
        <div class="col-md-5">
            <form action="MainController">
                <input type="text" name="bookName" placeholder="Search" value=<%=search%>>
                <button class="btn btn-warning btn-sm" type="submit" name="action" value="SearchBook">Search</button>
            </form>
        </div>
        <%
            AccountDTO acc = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (acc != null) {
                if (acc.getRoleID() == 2 || acc.getRoleID() == 3) {
        %>
            <div class="col-md-2 col">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <h5><a class="nav-link" href="LoadAccountController?accountID=<%=acc.getAccountID()%>">Hello <%=acc.getFullName()%></a></h5>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LogoutController">Logout</a>
                    </li>
                </ul>
            </div>
        <%
                } else {
        %>
        <div class="col-md-2 col">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <h5><a class="nav-link" href="">Hello <%=acc.getFullName()%></a></h5>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="LogoutController">Logout</a>
                </li>
            </ul>
        </div>
        <%
                }
            } else {
        %>
        <div class="col-md-1 col"></div>
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
                <%
                    String url= request.getServletPath();
                %>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/home.jsp")?"active":""%>" href="HomeController">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/about.jsp")?"active":""%>" href="about.jsp">About</a>
                </li>
                <%
                    if(acc != null){
                        if (acc.getRoleID() == 1) {
                %>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/manageAccount.jsp")?"active":""%>" href="ViewAccountController">Manager Account</a>
                </li>
                <%
                        }
                        if (acc.getRoleID() == 2) {
                %>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/addBook.jsp")?"active":""%>" href="addBook.jsp">Add Book</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/borrowStaff.jsp")?"active":""%>" href="ViewborrowStaffController">Staff Borrow List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/violation.jsp")?"active":""%>" href="ViewViolationController">Violation List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/about.jsp")?"active":""%>" href="#">News List</a>
                </li>
                <%
                        }
                        if (acc.getRoleID() == 3) {
                %>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/advancedSearch.jsp")?"active":""%>" href="LoadAdvancedSearchController">Advanced Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/borrow.jsp")?"active":""%>" href="ViewborrowController">Borrow List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= url.equals("/about.jsp")?"active":""%>" href="#">Following</a>
                </li>
                <%
                        }
                    }
                %>
            </ul>
        </div>
    </div>
</nav>
</div>
