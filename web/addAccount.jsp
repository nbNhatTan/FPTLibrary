<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Add Account</title>
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
            if (acc.getRoleID() != 1) {
                response.sendRedirect("error.jsp");
                return;
            }

        %>
       
        <div>


            <div>



            </div>
            <h3 class="title-text">ADD ACCOUNT</h3>
            <%
                AccountError accountError = (AccountError) request.getAttribute("ACCOUNT_ERROR");
                if (accountError == null) {
                    accountError = new AccountError();
                }
            %>
            <form action="MainController" method="POST">

                <table class="my-table">
                    <tr>
                        <td><label for="">Account ID:</label></td>
                        <td><input name="accountID" type="text" placeholder="Enter accountID" required=""><%= accountError.getAccountIDError()%></td>
                    </tr>

                    <tr>
                        <td><label for="">Full Name:</label></td>
                        <td><input name="fullName" type="text" placeholder="Enter Full Name" required=""><%= accountError.getFullNameError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Password:</label></td>
                        <td><input name="password" type="password" placeholder="Enter Password" required=""></td>
                    </tr>

                    <tr>
                        <td><label for="">Confirm:</label></td>
                        <td><input name="confirm" type="password" placeholder="Enter Password" required=""><%= accountError.getPasswordError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Role ID:</label></td>
                        <td><input name="roleID"type="text" placeholder="Enter Role ID" required=""><%= accountError.getRoleIDError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Mail:</label></td>
                        <td><input name="email" type="text" placeholder="Enter Mail" required=""><%= accountError.getEmailError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Address:</label></td>
                        <td><input name="address"type="text" placeholder="Enter Address" required=""><%= accountError.getAddressError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Phone:</label></td>
                        <td><input name="phone" type="text" placeholder="Enter Phone" required=""><%= accountError.getPhoneError()%></td>                            
                    </tr>                  

                    <tr>
                        <td></td>
                        <td class="a">
                            <button onclick="history.back()" type="button" class="btn btn-light btn-sm">Cancel</button>
                            <button  class="btn btn-warning btn-sm" type="submit" name="action" value="AddAccount">Add Account</button></td>
                    </tr>

                </table>
            </form>

        </div>



    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>