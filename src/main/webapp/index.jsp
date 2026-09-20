<%@ page import="com.Movie.utility.Model.User" %>

<%
    User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>MoviesHub</title>

    <link rel="stylesheet" href="/CSS/index.css">

</head>

<body>

    <!-- NAVBAR -->

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


    <!-- WELCOME BOX -->

    <div class="welcome-box">

        <%
            if (user != null) {
        %>

            <h2>
                Welcome <%= user.getName() %>
            </h2>

            <p>
                Discover the latest movies and book your favourite shows.
            </p>

            <a href="home.jsp" class="main-button">
                Explore Movies
            </a>

        <%
            } else {
        %>

            <h2>
                Welcome to MoviesHub
            </h2>

            <p>
                Discover the latest movies, explore different genres
                and languages, and book your favourite movies.
            </p>

            <a href="home.jsp" class="main-button">
                Explore Movies
            </a>

            <a href="login.jsp" class="main-button">
                Login
            </a>

            <a href="Register.jsp" class="main-button">
                Register
            </a>

        <%
            }
        %>

    </div>

</body>

</html>