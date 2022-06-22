<%-- 
    Document   : violation
    Created on : Jun 22, 2022, 5:04:37 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <link rel="stylesheet" href="styleViolation.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <div>

            <div class="table-container">
                <h1 class = "heading"> Danh sách phiếu phạt</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Mã phiếu phạt</th>
                            <th>Ngày thêm phiếu</th>
                            <th>Nội dung phạt</th>                       
                            <th>Tình trạng phiếu</th>


                        </tr>
                    </thead>
                    <tbody>
                        <tr>


                            <td data-lable="Mã phiếu phạt"> LOL1245687</td>
                            <td data-lable="Ngày thêm phiếu"> 26/06/2022</td>
                            <td data-lable="Nội dung phạt"> Trả sách trễ</td>
                            <td data-lable="Tình trạng phiếu"><span class="status_fail">[ Chưa thanh toán ]</span> </td>

                        </tr>

                        <tr>

                            <td data-lable="Mã phiếu phạt"> LOL8473242</td>
                            <td data-lable="Ngày thêm phiếu"> 24/06/2022</td>
                            <td data-lable="Nội dung phạt"> Làm mất sách</td>
                            <td data-lable="Tình trạng phiếu"><span class="status">[ Đã thanh toán ]</span> </td>

                        </tr>

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
