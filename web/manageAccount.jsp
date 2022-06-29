<%-- 
    Document   : manageAccount
    Created on : Jun 29, 2022, 7:39:47 AM
    Author     : Admin
--%>

<%@page import="java.sql.Date"%>
<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.BorrowDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Thông tin mượn sách</title>
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
        <link rel="stylesheet" href="CSS/styleBorrow.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div>

                <div class="table-container">
                    <h3 class = "">
                    <%
                        String roleID = (int) request.getAttribute("RoleID");
                        if (roleID == null) {
                            roleID = 0;
                        }
                    %>
                    <ol class="breadcrumb">
                        <li class="nac-item">
                            <a class="nav-link" href="ViewborrowStaffController"><%= roleID=0 ? "<strong>All Account</strong>" : "All Account"%></a>
                        </li>
                        <li class="nav-item " >
                            <a class="nav-link" href="ViewborrowStaffController?borrowStatus=Pending"><%= roleID = 2 ? "<strong>Staff</strong>" : "Staff"%></a>
                        </li>
                        <li class="nav-item " >
                            <a class="nav-link" href="ViewborrowStaffController?borrowStatus=Expired"><%= roleID=3 ? "<strong>User</strong>" : "User"%></a>
                        </li>

                    </ol>
                </h3>
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
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<AccountDTO> list = (List<AccountDTO>) request.getAttribute("ListAccount");
                            if (list != null) {
                                if (list.size() > 0) {
                                    for (AccountDTO p : list) {
                        %>
                        <tr>
                            <td><%= p.getAccountID()%></td>
                            <td><%= p.getFullName()%></td>
                            <td><%= p.getPassword()%></td>
                            <td><%= p.getRoleID()%></td>
                            <td><%= p.getEmail() %></td>
                            <td><%= p.getAddress()%></td>
                            <td><%= p.getPhone()%></td>
                            <td><%= p.getAddress()%></td>
                            <td><span class="<%= p.getStatus()%>">[<%= p.getStatus()%>]</span> </td>
                            <td>
                                <form action="MainController">
                                    <input type="hidden" name="bookingTicketID" value="<%= p.getBookingTicketID()%>"/>
                                    <button class="btn btn-light btn-sm" name="action" value="View">View</button>
                                    <%
                                        if (p.getBorrowStatus().equals("Pending")) {
                                    %>
                                    <button class="btn btn-light btn-sm" name="action" value="Confirm">Confirm</button>
                                    <%
                                        }
                                        if (p.getBorrowStatus().equals("Borrowing")) {
                                    %>
                                    <button class="btn btn-light btn-sm" name="action" value="Return">Return</button>
                                    <%
                                        }
                                    %>
                                </form>
                                <%
                                    if (p.getBorrowStatus().equals("Expired")) {
                                %>
                                <a href="createViolationTicket.jsp?bookingTicketID=<%= p.getBookingTicketID()%>"><button class="btn btn-light btn-sm">Create Violation</button></a>
                                <%
                                    }
                                %>  
                            </td>
                        </tr>
                        <%
                                    }
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="pagination">
            <ul>
                <li class="btn prev"><span><i class="fas fa-angle-left"></i> Prev</span></li>
                <li class="numb"><span>1</span></li>
                <li class="numb"><span>2</span></li>
                <li class="numb"><span>3</span></li>
                <li class="numb"><span>4</span></li>
                <li class="numb"><span>5</span></li>
                <li class="numb"><span>6</span></li>
                <li class="dots"><span>...</span></li>
                <li class="btn next"><span>Next<i class="fas fa-angle-right"></i></span></li>
            </ul>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
