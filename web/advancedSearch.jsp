<%-- 
    Document   : advancedSearch
    Created on : Jun 22, 2022, 3:54:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Thư viện FPTU HCM</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
              rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./style1.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
    <div class="main">
        <div class="row news">
            <div class="col-md-1"></div>
            <div class="col-md-10 contents">
                <div class="content">
                    
                    <div class="row">
                        
                        <div class="col-md-6 container-fluid">
                            <h5>Lập trình thật vui</h5>
                            <table width="100%">
                                <tr>
                                    <td>Authors: </td>
                                    <td>
                                        xxxx
                                    </td>
                                </tr>
                                <tr>
                                    <td>Publisher: </td>
                                    <td>
                                        Nhà xuất bản xxx
                                    </td>
                                </tr>
                                <tr>
                                    <td>Publication date: </td>
                                    <td>2018</td>
                                </tr>
                                <tr>
                                    <td>Edition: </td>
                                    <td>Tái bản lần 2</td>
                                </tr>
                                <tr>
                                    <td>Number of pages: </td>
                                    <td>200</td>
                                </tr>
                                <tr>
                                    <td>Language:</td>
                                    <td>Tiếng Việt</td>
                                </tr>
                                <tr>
                                    <td>Loại Sách:</td>
                                    <td>Tạp chí Khoa Học</td>
                                </tr>
                            </table>
                            Booktag: 

                            <p>Uploaded: 1 year, 3 months ago.</p>
                            <p>Numbers: 20 left</p>
                            

                        </div>
                    </div>
                </div>


            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="contents row">
            <div class="col-md-1"></div>
            <div class="col-md-10 contents">
                <div class="content">
                    <h6>Booking Confirm: </h6>
                    <button class="btn btn-light btn-sm">Cancel</button>
                    <button class="bookingButton btn btn-light btn-sm">Confirm</button>
                </div>


            </div>
            <div class="col-md-1"></div>
        </div>
       
    </div>
   <jsp:include page="footer.jsp"></jsp:include>


   
</body>
</html>
