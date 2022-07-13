<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Đăng nhập thư viện FPTU HCM</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/style.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet" />
        <link   rel="stylesheet" 
                href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
                crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
                crossorigin="anonymous">
        </script>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>


            <div>


                <div>



                </div>
                <h3 class="title-text">LOGIN</h3>

                <form action="MainController" method="P0ST">

                    <table class="my-table">

                        
                        <tr>
                            <td><label for="">User: </label></td>
                            <td><input type="text" name="accountID" placeholder="Enter User Name"></td>
                        </tr>
                        <tr>
                            <td><label for="">Password: </label></td>
                            <td><input type="password" name="password" placeholder="Enter Password"></td>
                        </tr>
                    </table>
                    <div class="row b">
                        <div  class="col-md-5"></div>
                        <div class="col-md-2">


                            <input class="btn btn-warning btn-sm" type="submit" name="action" value="Login"/>
                            <a href="register.jsp"> <button class="btn btn-warning btn-sm" type="button">Register</button> </a>
                            <div class="row">
                                <div class="col-md-3">
                                    <a class="btn btn-outline-dark" href="https://accounts.google.com/o/oauth2/auth?scope=email profile&redirect_uri=http://localhost:8080/FPTLibrary-Git/LoginGoogleController&response_type=code
                                       &client_id=53864111144-aj9dkmdo6j87dl266muvck01ehdfnbjk.apps.googleusercontent.com&approval_prompt=force" role="button" style="text-transform:none">
                                        <img width="20px" style="margin-bottom:3px; margin-right:5px" alt="Google sign-in" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png" />
                                        Login with Google
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5"></div>
                    </div>


                </form>

            </div>


        <jsp:include page="footer.jsp"></jsp:include>

        <script> window.alert("Xin chào!");</script>
    </body>

</html>