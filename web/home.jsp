<%-- 
    Document   : home
    Created on : Jun 19, 2022, 4:40:05 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" , initial-scale="1" />
        <title>Thư viện FPTU HCM</title>
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
        <link rel="stylesheet" href="./style.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <div class="main">
                <div class="row news">
                    <div class="col-md-1"></div>
                    <div class="col-md-10 contents">

                        <div class="new row">
                            <div class="col-md-3 new-item text-center">
                                <img src="https://cdn.glitch.global/b5568004-6653-447c-bb6a-cd2cd0c89e38/SEBook.png?v=1653570818013"
                                     width="188"
                                     height="230" />
                                <p>Tuoi tre</p>
                            </div>
                            <div class="col-md-3 new-item text-center">
                                <img src="https://cdn.glitch.global/b5568004-6653-447c-bb6a-cd2cd0c89e38/JBasicBook.png?v=1653570829608"
                                     width="188"
                                     height="230" />
                                <p>Tuoi tre</p>
                            </div>
                            <div class="col-md-3 new-item text-center">
                                <img src="https://cdn.glitch.global/b5568004-6653-447c-bb6a-cd2cd0c89e38/ProgramingAndLife.png?v=1653570834023"
                                     width="188"
                                     height="230" />
                                <a href="MainController?action=Detail&bookID=1">Tuoi tre</a>
                            </div>
                            <div class="col-md-3 new-item text-center">
                                <img src="https://cdn.glitch.global/b5568004-6653-447c-bb6a-cd2cd0c89e38/Young.png?v=1653570847480"
                                     width="188"
                                     height="230" />
                                <p>Tuoi tre</p>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-1"></div>
                </div>
                <div class="contents row">
                    <div class="col-md-1"></div>
                    <div class="col-md-10 contents">
                        <div class="content row">
                            <div class="contents col-md-8">
                                <div class="main-content">
                                    a
                                </div>
                            </div>  
                            <div class="contents col-md-4">
                                <div class="announecement">
                                    a
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-1"></div>
                </div>
            </div>


        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>