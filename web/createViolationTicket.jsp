<%-- 
    Document   : register
    Created on : Jun 15, 2022, 7:43:12 AM
    Author     : NhatTan
--%>

<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Create Violation Ticket</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/style.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet" />
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

<%
            AccountDTO acc = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
            if (acc == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            if (acc.getRoleID() != 2) {
                response.sendRedirect("error.jsp");
                return;
            }

        %>
            <div>


                <div>



                </div>
                <h3 class="title-text">Create Violation</h3>
                <form action="MainController" method="POST">

                    <table class="my-table">
                        <tr>
                            <td><label class="col-form-label">Reason:</label></td>
                            <td>
                                <select name="description" class="form-control">
                                    <option value="Expired">Expired</option>
                                    <option value="Lost">Lost</option>
                                    <option value="Damaged">Damaged</option>
                                </select>
                            </td>
                        </tr>
                        <tr><td><p></p></td></tr>
                        <tr>
                            <td></td>
                            <td class="a">
                                <%
                                    String bookingTicketID = request.getParameter("bookingTicketID");
                                %>
                                <input type="hidden" name="bookingTicketID" value="<%= bookingTicketID%>"/>
                                <button onclick="history.back()" type="button" class="btn btn-light btn-sm">Cancel</button>
                                <button class="btn btn-warning btn-sm" type="submit" name="action" value="CreateViolationticket">Create Violation</button>
                            </td>
                        </tr>

                    </table>
                </form>

            </div>



        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
