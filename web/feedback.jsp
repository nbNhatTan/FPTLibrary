<%-- 
    Document   : feedback
    Created on : Jul 11, 2022, 2:07:16 PM
    Author     : anhkhoa
--%>

<%@page import="sample.DTO.FeedBackDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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


         <%          
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <form action="MainController" >
            Search<input type="text" name="search"   value="<%= search %>" placeholder="input your text"/>
            <input type="submit" name="action"  value="ViewFeedback"/>
        </form>
          <%
            List<FeedBackDTO> listFeedback = (List<FeedBackDTO>) request.getAttribute("LIST_FEEDBACK");
            if (listFeedback != null) {
                if (listFeedback.size()>0) {
        %>   
            
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Feedback ID</th>
                    <th>User ID</th>
                    <th>Booking ticket ID</th>
                    <th>Comment</th>
                   
                </tr>
            </thead>
            <tbody>
                <%
                    int count=1;
                    for (FeedBackDTO product : listFeedback) {
                %>
        <tr>
            <form action="MainController">   
                
            
                
                    <td><%= count++%></td>
                    
                    <td>
                        <%=product.getFeedbackID()%>
                        <input type="hidden" name="FeedbackID" value="<%=product.getFeedbackID()%>"/>
                    </td>
                    
                    <td>
                        <%= product.getUserID()%>
                        <input type="hidden" name="UserID" value="<%= product.getUserID()%>"/>
                    </td>
                    
                    
                    <td>
                        <%= product.getBookingTicketID()%>
                        <input type="hidden" name="bookingTicketID" value="<%=product.getBookingTicketID()%>"/>
                    </td>
                    <td>  
                        <%= product.getComment()%>
                        <input type="hidden" name="comment" value="<%= product.getComment()%>"/>
                    </td>
                   
                 
                    
            
                    
               
            </form>
            
            <%
                        }
                    %>
        </tr>
            </tbody>
        </table>
        
                <%
                }
            }
        %> 

        <jsp:include page="footer.jsp"></jsp:include>
        
        <script> window.alert("Xin chào!");</script>
    </body>
</html>
