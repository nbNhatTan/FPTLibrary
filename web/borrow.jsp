<%-- 
    Document   : borrow
    Created on : Jun 14, 2022, 5:07:23 PM
    Author     : NhatTan
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
                    <h1 class = "heading">Borrow List</h1>
                    <table class="borrow-table">
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Book Name</th>
                                <th>BookingTicketID</th>
                                <th>Borrow Date</th>
                                <th>Expiry Date</th>
                                <th>Return Date</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                            List<BorrowDTO> list = (List<BorrowDTO>) request.getAttribute("ListBorrow");
                            if (list != null) {
                                if (list.size() > 0) {
                                    for (BorrowDTO p : list) {
                        %>
                        <tr>
                            <td>
                                <img src="<%= p.getImage() %>" width="100" height="150"/>
                            </td>
                            <td><%= p.getBookName()%></td>
                            <td><%= p.getBookingTicketID()%></td>
                            <td><%= p.getBorrowDate()%></td>
                            <td><%= p.getExpiredDate()%></td>
                            <td>
                                <% if (p.getReturnDate() == null) {
                                        String returnDate = "";
                                        out.print(returnDate);
                                    } else {
                                        out.print(p.getReturnDate());
                                    }
                                %>
                            </td>
                            <td><span class="<%= p.getBorrowStatus()%>">[<%= p.getBorrowStatus()%>]</span> </td>
                            <td>
                                <form action="MainController">
                                    <input type="hidden" name="bookingTicketID" value="<%= p.getBookingTicketID()%>"/>
                                    <%
                                        if (p.getBorrowStatus().equals("Expired")) {
                                    %>
                                    <button class="btn btn-light btn-sm" name="action" value="">View Violation</button>
                                    <%
                                        }
                                    %>
                                </form>
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
                <li class="btn next"><span>Next <i class="fas fa-angle-right"></i></span></li>
            </ul>


        </div>






        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
