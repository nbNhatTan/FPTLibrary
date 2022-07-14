<%@page import="sample.DTO.AccountDTO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Manager Account</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/styleBorrow.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            AccountDTO acc = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (acc == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            if (acc.getRoleID() != 1) {
                response.sendRedirect("error.jsp");
                return;
            }

        %>
            <div>
                <div class="table-container">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-10">
                                <h2>Manage <b>Account</b></h2>
                            </div>
                            <div class="col-sm-2">
                                <a href="addAccount.jsp"  class="btn btn-warning btn-sm" ><i class="material-icons">&#xE147;</i> <span>Add New Account</span></a>
                            </div>
                        </div>
                    </div>
                    <table class="borrow-table">
                        <thead>
                            <tr>
                                <th>Account ID</th>
                                <th>Full Name</th>
                                <th>Password</th>
                                <th>Role ID</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Phone</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                            List<AccountDTO> list = (List<AccountDTO>) request.getAttribute("listA");
                            if (list != null) {
                                if (list.size() > 0) {
                                    for (AccountDTO p : list) {
                                        if (p.getStatus()) {
                        %>
                        <tr>
                            <td><%= p.getAccountID()%></td>
                            <td><%= p.getFullName()%></td>
                            <td><%= p.getPassword()%></td>
                            <td><%= p.getRoleID()%></td>
                            <td><%= p.getEmail()%></td>
                            <td><%= p.getAddress()%></td>
                            <td><%= p.getPhone()%></td>
                            <td>
                                <a href="LoadManageController?accountID=<%=p.getAccountID()%>"  class="edit" ><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                <a href="DeleteAccountController?accountID=<%=p.getAccountID()%>" class="delete" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                            </td>
                        </tr>
                        <%
                                        }
                                    }
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
