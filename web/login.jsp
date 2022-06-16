<%-- 
    Document   : login
    Created on : Jun 16, 2022, 9:31:15 AM
    Author     : admin
--%>

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
  <nav class="navbar navbar-expand-md navbar-light bg-light">
    <div class="container-fluid padding">
      <div class="col-md-5">
        <div class="p-2">
          <a class="navbar-branch" href="#">
            <img class="img"
              src="https://cdn.glitch.global/b5568004-6653-447c-bb6a-cd2cd0c89e38/LogoFPT.png?v=1653532923912"
              width="325" height="71" />
          </a>
        </div>
      </div>
      <div class="col-md-6">
        <input type="text" name="search" placeholder="Search" />
        <button class="btn btn-warning btn-sm">Search</button>
      </div>

      <div class="col-md-1 col">
        <button class="btn btn-warning btn-sm">Login</button>
      </div>
    </div>
  </nav>

  <nav class="nav navbar-expand-md navbar-light bg-light sticky-top">
    <div>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link active" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Team</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Connect</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>



  <div>


    <div>



    </div>
    <h3 class="title-text">LOGIN</h3>

    <form action="MainController" method="P0ST">

      <table class="my-table">
        <tr>
          <td><label for="">User:</label></td>
          <td><input type="text" name="accountID" placeholder="Enter User Name"></td>
        </tr>

        <tr>
          <td><label for="">Password</label></td>
          <td><input type="password" name="password" placeholder="Enter Password"></td>
        </tr>

       

      </table>
      <div class="row b">
        <div  class="col-md-5"></div>
        <div class="col-md-2 padding">
        

        <input class="btn btn-warning btn-sm" type="submit" name="action" value="Login"/>
        <td class="b"><button class="btn btn-warning btn-sm" type="button">Register</button></td>
      </div>
        <div class="col-md-5"></div>
      </div>


    </form>

  </div>
  </div>











  <footer class="text-light">
    <div class="container">
      <div class="row">
        <div class="col-md-3 col-lg-4 col-xl-3">
          <h5>About</h5>
          <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25" />
          <p class="mb-0">Assignment PRJ301 SP2022</p>
        </div>

        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
          <h5>Informations</h5>
          <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25" />
          <ul class="list-unstyled">
            <li><a href="">Facebook</a></li>
            <li><a href="">Instagram</a></li>
            <li><a href="">GiHub</a></li>
            <li><a href="">Youtube</a></li>
          </ul>
        </div>

        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto"></div>

        <div class="col-md-4 col-lg-3 col-xl-3">
          <h5>Contact</h5>
          <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25" />
          <ul class="list-unstyled">
            <li><i class="fa fa-home mr-2"></i> FPT Uni</li>
            <li><i class="fa fa-envelope mr-2"></i> andeptrai@gmail.com</li>
            <li><i class="fa fa-phone mr-2"></i> + 84 877660374</li>
            <li><i class="fa fa-print mr-2"></i></li>
          </ul>
        </div>
        <div class="col-12 copyright mt-3">
          <p class="float-left">
            <a href="#">Back to top</a>
          </p>
        </div>
      </div>
    </div>
  </footer>
</body>

</html>