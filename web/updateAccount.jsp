<%-- 
    Document   : register
    Created on : Jun 15, 2022, 9:59:49 PM
    Author     : Admin
--%>

<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.Error.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Đăng kí thư viện FPTU HCM</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="style.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet" />
    </head>

    <body>
       <jsp:include page="header.jsp"></jsp:include>


        <div>


            <div>

            </div>
            <h3 class="title-text">UPDATE ACCOUNT</h3>
            <%
                AccountError accountError = (AccountError) request.getAttribute("ACCOUNT_ERROR");
                if (accountError == null) {
                    accountError = new AccountError();
                }
                
                AccountDTO acc =new AccountDTO();
            %>
            <form action="MainController" method="POST">

                <table class="my-table">

                    <tr>
                        <td><label for="">Full Name:</label></td>
                        <td><input name="fullName" type="text" placeholder="Enter New Full Name"><%= accountError.getFullNameError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Password:</label></td>
                        <td><input name="password" type="text" placeholder="Enter New Password" ></td>
                    </tr>

                    <tr>
                        <td><label for="">Confirm:</label></td>
                        <td><input name="confirm" type="text" placeholder="Enter Password" ><%= accountError.getPasswordError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Mail:</label></td>
                        <td><input name="email" type="text" placeholder="Enter New Email" ><%= accountError.getEmailError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Address:</label></td>
                        <td><input name="address"type="text" placeholder="Enter New Address" ><%= accountError.getAddressError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Phone:</label></td>
                        <td><input name="phone" type="text" placeholder="Enter New Phone" ><%= accountError.getPhoneError()%></td>                            
                    </tr>                  

                    <tr>
                        <td></td>
                        <td class="a"><button class="btn btn-warning btn-sm" type="submit" name="action" value="UpdateAccount">UPDATE</button></td>

                    </tr>

                </table>
            </form>

        </div>
    </div>


    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
