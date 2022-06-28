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
                        </div>
                        <div class="col-md-5"></div>
                    </div>


                </form>

            </div>


        <jsp:include page="footer.jsp"></jsp:include>
        
        <script> window.alert("Xin chào!");</script>
    </body>

</html>