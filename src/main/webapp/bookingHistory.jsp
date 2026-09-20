<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.Movie.utility.Model.User" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Booking History - MoviesHub</title>

    <link rel="stylesheet" href="/CSS/bookingHistory.css">

</head>

<body>


<!-- =========================
     NAVBAR
========================= -->

<div class="navbar">

    <div class="logo">
        MoviesHub
    </div>

    <div class="nav-links">

        <a href="index.jsp">
            Home
        </a>

        <%
            if (user != null) {
        %>

            <a href="bookingHistory.jsp">
                Booking History
            </a>

            <a href="Profile.jsp">
                Profile
            </a>

            <a href="logout">
                Logout
            </a>

        <%
            } else {
        %>

            <a href="login.jsp">
                Login
            </a>

            <a href="Register.jsp">
                Register
            </a>

        <%
            }
        %>

    </div>

</div>


<!-- =========================
     CONTENT
========================= -->

<div class="container">

    <div class="title">
        My Booking History
    </div>

    <div id="loading" class="loading">
        Loading bookings...
    </div>

    <div id="error" class="error"></div>

    <div id="bookingContainer"></div>

</div>


<!-- USER ID FROM SESSION -->

<script>

    let userId = <%= user.getUser_id() %>;

</script>


<script src="/Scripts/bookingHistory.js"></script>

</body>

</html>