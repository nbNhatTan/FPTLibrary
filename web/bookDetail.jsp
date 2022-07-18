<%-- 
    Document   : Detail
    Created on : Jun 14, 2022, 11:09:52 AM
    Author     : NhatTan
--%>

<%@page import="sample.DAO.FeedbackDAO"%>
<%@page import="sample.DTO.FeedBackDTO"%>
<%@page import="sample.DTO.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.DTO.AccountDTO"%>
<%@page import="sample.DTO.BookDTO"%>
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
        <script src="https://kit.fontawesome.com/c8e4d183c2.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="CSS/style1.css" />
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
                    <%
                        AccountDTO Users = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
                        String UsersID = "";
                        if (Users != null) {
                            UsersID = Users.getAccountID();
                        }
                        BookDTO book = (BookDTO) request.getAttribute("DETAIL_BOOK");

                        if (book != null) {

                    %>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="bookDetailImage text-center container-fluid">
                                <img src="<%= book.getImage()%>"/>
                            </div>
                        </div>
                        <div class="col-md-6 container-fluid">
                            <h5><%= book.getBookName()%></h5>
                            <table width="100%">
                                <tr>
                                    <td><h6>Authors: </h6></td>
                                    <td><%= book.getAuthor()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Publisher: </h6></td>
                                    <td><%= book.getPublisher()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Publication Year: </h6></td>
                                    <td><%= book.getPublishYear()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Language: </h6></td>
                                    <td><%= book.getLanguage()%></td>
                                </tr>
                                <tr>
                                    <td><h6>DDC: </h6></td>
                                    <td><%= book.getDDC()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Bookshelf: </h6></td>
                                    <td><%= book.getBookshelf()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Description: </h6></td>
                                    <td><%= book.getDescription()%></td>
                                </tr>
                                <tr>
                                    <td><h6>Book Tag: </h6></td>
                                    <td class="list-unstyled">
                                <li>
                                    <%
                                        List<CategoryDTO> listCategory = (List<CategoryDTO>) request.getAttribute("LIST_CATEGORY");
                                        if (listCategory != null) {
                                            for (CategoryDTO c : listCategory) {
                                    %>
                                    <a href="" style="font-size: 12px; background: #F3F3F3; border: 1px solid #E8E8E8; 
                                       display: inline-block; color: #000; padding: 2px 5px; text-align: center;"><%=c.getCategoryName()%></a>
                                    <%
                                            }
                                        }
                                    %>
                                </li>
                                </td>
                                </tr>
                            </table>                            
                            <a href="BookDetailController?action=BkConfirm&bookID=<%= book.getBookID()%>"><button type="button" class="bookingButton btn btn-light btn-sm">Book</button></a>

                            <button onclick="history.back()" type="button" class="btn btn-dark btn-sm">Back</button>

                        </div>
                    </div>



                    <div >
                        <form action="MainController">
                            <input type ="hidden" name="userID" value="<%= UsersID%>" />
                            <input type="hidden" name="bookID" value="<%=book.getBookID()%>"  />

                            <div>
                                <h5>Your comment </h5>
                            </div>

                            <textarea type="text"   name="comment" required="" /></textarea>


                            <div >
                                

                                <label class="col-md-12 mb-0">YOUR REVIEW</label>
                                <div class="stars">

                                    <input class="star star-5" id="star-5" type="radio" name="star" value="5" required=""/>
                                    <label class="star star-5" for="star-5"></label>
                                    <input class="star star-4" id="star-4" type="radio" name="star" value="4" required=""/>
                                    <label class="star star-4" for="star-4"></label>
                                    <input class="star star-3" id="star-3" type="radio" name="star" value="3" required=""/>
                                    <label class="star star-3" for="star-3"></label>
                                    <input class="star star-2" id="star-2" type="radio" name="star" value="2" required=""/>
                                    <label class="star star-2" for="star-2"></label>
                                    <input class="star star-1" id="star-1" type="radio" name="star" value="1" required=""/>
                                    <label class="star star-1" for="star-1"></label>


                                </div>
                            </div>


                            <div class="feedbackButton">
                                <button type="submit"  class="btn btn-light btn-sm"  name="action" value="CreateFeedback">Feedback</button>               
                            </div>


                        </form>

                    </div>



                    <div style=" text-align: center"> 
                        <h2 class="comment_heading"> COMMENT BY OTHER USER</h2>
                    </div> 



                    <%
                        FeedbackDAO dao = new FeedbackDAO();
                        List<FeedBackDTO> listFeedback = dao.getFeedbackList(book.getBookID());

                        if (listFeedback != null) {
                            if (listFeedback.size() > 0) {
                    %>


                    <div>

                        <div>                    
                            <%
                                for (FeedBackDTO feedback : listFeedback) {
                            %>                
                            <div class="box_comment">

                                <div >
                                    <div >

                                        <div class="user_name">
                                            <strong> User </strong>
                                            <%= feedback.getUserID()%>

                                        </div>
                                            
                                        <div >                                           
                                                <%
                                                    int star;
                                                    for (star = 1; star <= feedback.getStar(); star++) {
                                                %>
                                                <i class="fas fa-star " style="color : #ffcc00 " ></i>
                                                <%
                                                    }
                                                %>
                                        </div>    


                                        <div class = "client_comment">  
                                            <strong>  Comment </strong>
                                            <div><%= feedback.getComment()%></div>

                                        </div>

                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>

                        </div>
                        <%
                                    }
                                }
                            }
                        %>

                    </div> 



                </div>









                <div class="col-md-1"></div>
            </div>
            <div class="contents row">
                <div class="col-md-1"></div>
                <div class="col-md-10 contents">
                    <div class="content">
                        <hr>
                    </div>

                </div>
                <div class="col-md-1"></div>
            </div>
            <div class="introduce row">
                <div class="col-md-1"></div>
                <div class="col-md-10 contents">
                    <div class="new">
                        <h6 class="text-center">More like This</h6>

                        <div class="new2 row" >
                            <div class="col-md-1"></div>
                            <%
                                List<BookDTO> list = (List<BookDTO>) session.getAttribute("TOP_BOOK");
                                if (list != null) {
                                    if (!list.isEmpty()) {
                                        for (BookDTO b : list) {
                            %>
                            <div class="col-md-2 new-item text-center">
                                <a href="MainController?action=Detail&bookID=<%= b.getBookID()%>"><img src="<%= b.getImage()%>" width="188" height="230"/></a>
                                <a href="MainController?action=Detail&bookID=<%= b.getBookID()%>"><p><%= b.getBookName()%></p></a>
                            </div>
                            <%
                                        }
                                    }
                                }
                            %>
                            <div class="col-md-1"></div>
                        </div>
                    </div>

                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
    </div>           
    <jsp:include page="footer.jsp"></jsp:include>





</body>
</html>

