<%-- 
    Document   : violation
    Created on : Jun 21, 2022, 8:11:30 AM
    Author     : Admin
--%>

<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.ViolationTicketDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Thông tin phiếu phạt</title>
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
                    <%
                        String staffID = (String) request.getAttribute("StaffID");
                    %>
                    <h3>
                        <ol class="breadcrumb">
                            <li class="nac-item">
                                <a class="nav-link" href="ViewViolationController"><%= staffID.equals("%%") ? "<strong>All Violation Ticket</strong>" : "All Violation Ticket"%></a>
                            </li>
                            <%
                                AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
                            %>
                            <li class="nav-item " >
                                <a class="nav-link" href="ViewViolationController?staffID=<%= loginAccount.getAccountID()%>"><%= !staffID.equals("%%") ? "<strong>Violation Ticket by me</strong>" : "Violation Ticket by me"%></a>
                            </li>
                        </ol>
                    </h3>
                    <%
                        String status = (String) request.getAttribute("Status");
                        if(status==null) status="";
                    %>
                    <h6>
                        <ol class="breadcrumb">
                            <li class="nac-item">
                                <a class="nav-link" href="ViewViolationController?staffID=<%=staffID%>&status=0"><%= status.equals("0") ? "<strong>Paid</strong>" : "Paid"%></a>
                            </li>
                            <li class="nav-item " >
                                <a class="nav-link" href="ViewViolationController?staffID=<%=staffID%>&status=1"><%= status.equals("1") ? "<strong>Unpaid</strong>" : "Unpaid"%></a>
                            </li>
                        </ol>
                    </h6>
                    <table class="borrow-table">
                        <thead>
                            <tr>
                                <th>Violation Ticket ID</th>
                                <th>Date Created</th>
                                <th>Description</th>                       
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<ViolationTicketDTO> list = (List<ViolationTicketDTO>) request.getAttribute("ListViolationStaff");
                                if (list != null) {
                                    if (list.size() > 0) {
                                        for (ViolationTicketDTO v : list) {
                            %>
                            <tr>
                                <td><%=v.getViolationTicketID()%></td>
                                <td><%=v.getCreateDate()%></td>
                                <td><%=v.getDescription()%></td>
                                <%
                                    if (v.getTicketStatus()) {
                                %>
                                <td><span class="Expired">[Unpaid]</span> </td>
                                <td>
                                    <a href="SendMailController?ViolationTicketID=<%= v.getViolationTicketID() %>"><button class="btn btn-light btn-sm">Send Mail</button></a>
                                </td>
                                <%
                                } else {
                                %>
                                <td><span class="Borrowing">[Paid]</span> </td>
                                <td>
                                    
                                </td>
                                <%
                                    }
                                %>
                                
                            </tr>
                            <%
                                        }
                                    }
                                }
                            %>
                        </tbody>
                    </table>
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
                        <li class="btn next"><span>Next <i class="fas fa-angle-right"></i></span></li>
                    </ul>


                </div>          

            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

