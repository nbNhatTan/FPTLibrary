<%-- 
    Document   : borrow
    Created on : Jun 15, 2022, 10:40:09 PM
    Author     : Admin
--%>

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
        <link rel="stylesheet" href="styleBorrow.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
    <body>
       <jsp:include page="header.jsp"></jsp:include>

        <div>

            <div class="table-container">
                <h1 class = "heading"> Đơn mượn sách</h1>
                <table class="borrow-table">
                    <thead>
                        <tr>
                            <th>Cuốn sách</th>
                            <th>Tên sách</th>
                            <th>Mã sách</th>
                            <th>Ngày mượn</th>
                            <th>Hạn trả</th>
                            <th>Ngày trả</th>
                            <th>Tình trạng</th>


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
                            <td data-lable="Cuốn sách">
                                <img
                                    src="https://cdn.glitch.global/b5568004-6653-447c-bb6a-cd2cd0c89e38/Young.png?v=1653570847480"
                                    width="100"
                                    height="150"
                                    />

                            </td>
                            <td data-lable="Tên sách"><%= p.getBookName()%></td>
                            <td data-lable="Mã sách"><%= p.getBookItemID()%></td>
                            <td data-lable="Ngày mượn"><%= p.getBorrowDate()%></td>
                            <td data-lable="Hạn trả"><%= p.getExpiredDate()%></td>
                            <td data-lable="Ngày trả"><%= p.getReturnDate()%></td>
                            <td data-lable="Tình trạng"><span class="status">[<%= p.getBorrowStatus()%>]</span> </td>

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
