<%-- 
    Document   : register
    Created on : Jun 15, 2022, 9:59:49 PM
    Author     : Admin
--%>

<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Update</title>
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
            if (acc.getRoleID() == 1) {
                response.sendRedirect("error.jsp");
                return;
            }

        %>
<div>


            <div>

            </div>
            <h3 class="title-text">UPDATE ACCOUNT</h3>
            <%
                AccountError accountError = (AccountError) request.getAttribute("ACCOUNT_ERROR");
                if (accountError == null) {
                    accountError = new AccountError();
                }
                
                AccountDTO acc =(AccountDTO) request.getAttribute("ACCOUNT_DETAIL");
            %>
            <form action="MainController" method="POST" onsubmit="return create(this);">
                <input name="action" value="UpdateAccount" type="hidden"/>
                <table class="my-table">
                    <tr>
                        <td><label for="">Account ID:</label></td>
                        <td><input name="accountID" type="text" class="form-control" value="<%= acc.getAccountID()%>" readonly=""></td>
                    </tr>

                    <tr>
                        <td><label for="">Role ID:</label></td>
                        <td><input name="roleID"type="text" class="form-control" value="<%= acc.getRoleID()%>" readonly=""></td>                            
                    </tr>
                    
                    <tr>
                        <td><label for="">Full Name:</label></td>
                        <td><input name="fullName" type="text" class="form-control" value="<%= acc.getFullName()%>" placeholder="Enter Full Name"><%= accountError.getFullNameError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Password:</label></td>
                        <td><input name="password" type="password" class="form-control" placeholder="Enter Password" value="<%= acc.getPassword()%>"></td>
                    </tr>

                    <tr>
                        <td><label for="">Confirm:</label></td>
                        <td><input name="confirm" type="password" class="form-control" placeholder="Enter Password" value="<%= acc.getPassword()%>"><%= accountError.getConfirmError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Mail:</label></td>
                        <td><input name="email" type="text" class="form-control" placeholder="Enter Mail" value="<%= acc.getEmail()%>"><%= accountError.getEmailError()%></td>                            
                    </tr>

                    <tr>
                        <td><label for="">Address:</label></td>
                        <td><input name="address"type="text" class="form-control" placeholder="Enter Address" value="<%= acc.getAddress()%>"><%= accountError.getAddressError()%></td>                            
                    </tr>

                    <tr>
                        <td><label>Phone:</label></td>
                        <td><input name="phone" type="text" class="form-control" placeholder="Enter Phone" value="<%= acc.getPhone()%>"><%= accountError.getPhoneError()%></td>                            
                    </tr>                  
                    <tr>
                        <td></td>
                        <td></td>                            
                    </tr>                  

                    <tr>
                        <td></td>
                        <td class="a">
                            <button class="btn btn-warning btn-sm">UPDATE</button>
                            <button onclick="history.back()" type="button" class="btn btn-dark btn-sm">Back</button>
                        </td>
                    </tr>

                </table>
            </form>

        </div>
    <jsp:include page="footer.jsp"></jsp:include>
    
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
        function create(form) {
            Swal.fire({
                title: 'Are you sure?',
                text: "You want to update your information.",
                icon: 'question',
                showCancelButton: true,
                confirmButtonColor: '#F5D98F',
                cancelButtonColor: '#F7E5D7',
                confirmButtonText: 'Yes, I want!'
            }).then((result) => {
                if (result.isConfirmed) {
                    form.submit();
                }
            });
            return false;
        }
    </script>
</body>
</html>