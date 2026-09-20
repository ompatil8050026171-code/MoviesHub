<%@ page import="com.Movie.utility.Model.User" %>

<%
    User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>MoviesHub</title>

    <link rel="stylesheet" href="CSS/home.css">

</head>


<body>

    <!-- ================= NAVBAR ================= -->

    <div class="navbar">

        <div class="logo">
            MoviesHub
        </div>


        <div class="search-box">

            <input
                type="text"
                id="searchInput"
                placeholder="Search for Movies..."
            >

        </div>


        <div class="nav-buttons">

            <%
                if (user != null) {
            %>

                <button
                    class="nav-btn"
                    onclick="goToHome()">

                    Home

                </button>


                <button
                    class="nav-btn"
                    onclick="goToBookingHistory()">

                    Booking History

                </button>


                <button
                    class="nav-btn"
                    onclick="goToProfile()">

                    Profile

                </button>


                <button
                    class="logout-btn"
                    onclick="logout()">

                    Logout

                </button>

            <%
                } else {
            %>

                <button
                    class="login-btn"
                    onclick="goToLogin()">

                    Login

                </button>


                <button
                    class="register-btn"
                    onclick="goToRegister()">

                    Register

                </button>

            <%
                }
            %>

        </div>

    </div>


    <!-- ================= MENU ================= -->

    <div class="menu">

        <a href="home.jsp">
            Movies
        </a>

        <a href="#">
            Events
        </a>

        <a href="#">
            Sports
        </a>

        <a href="#">
            Offers
        </a>

    </div>


    <!-- ================= BANNER ================= -->

    <div class="banner">

        <div>

            <%
                if (user != null) {
            %>

                <h1>
                    Welcome <%= user.getName() %>
                </h1>

            <%
                } else {
            %>

                <h1>
                    Welcome to MoviesHub
                </h1>

            <%
                }
            %>


            <p>
                Book your favourite movies and enjoy the show!
            </p>

        </div>

    </div>


    <!-- ================= MOVIES ================= -->

    <div class="movie-section">

        <h2 class="section-title">
            Recommended Movies
        </h2>


        <div id="loading">
            Loading movies...
        </div>


        <div id="error">
        </div>


        <div id="noMovies">
            No movies found.
        </div>


        <div
            class="movie-container"
            id="movieContainer">

        </div>

    </div>


    <!-- ================= JAVASCRIPT ================= -->

    <script src="Scripts/home.js"></script>

</body>

</html>