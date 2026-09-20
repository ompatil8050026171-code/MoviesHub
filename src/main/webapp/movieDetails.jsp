<%@ page import="com.Movie.utility.Model.User" %>

<%
    User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Movie Details - MoviesHub</title>

    <link rel="stylesheet" href="CSS/movieDetails.css">

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


    <!-- ================= MOVIE SLIDER ================= -->

    <div class="movie-slider">

        <img
            src="MovieImages/coolie.jpg"
            class="slide active"
        >

        <img
            src="MovieImages/dhurandhar_revenge.jpg"
            class="slide"
        >

        <img
            src="MovieImages/dhurandhar.jpg"
            class="slide"
        >

        <img
            src="MovieImages/idhayam_murali.jpg"
            class="slide"
        >

        <img
            src="MovieImages/kantara_chapter1.jpg"
            class="slide"
        >

        <img
            src="MovieImages/kgf_chapter1.jpg"
            class="slide"
        >

        <img
            src="MovieImages/kgf_chapter2.jpg"
            class="slide"
        >

        <img
            src="MovieImages/pushpa_2_the_rule.jpg"
            class="slide"
        >

        <img
            src="MovieImages/pushpa_the_rampage.jpg"
            class="slide"
        >

        <img
            src="MovieImages/retro.jpg"
            class="slide"
        >

        <img
            src="MovieImages/saiyaara.jpg"
            class="slide"
        >

        <img
            src="MovieImages/thug_life.jpg"
            class="slide"
        >

        <img
            src="MovieImages/tourist_family.jpg"
            class="slide"
        >

        <img
            src="MovieImages/toxic.jpg"
            class="slide"
        >

        <img
            src="MovieImages/war2.jpg"
            class="slide"
        >

    </div>


    <!-- ================= MOVIE DETAILS ================= -->

    <div id="loading">
        Loading movie details...
    </div>


    <div id="error">
    </div>


    <div
        class="movie-details"
        id="movieDetails"
        style="display:none;">

        <img
            id="movieImage"
            class="movie-poster"
            src=""
            alt="Movie Poster"
        >


        <div class="movie-info">

            <h1 id="movieTitle">
            </h1>


            <div class="rating">

                &#9733;

                <span id="movieRating">
                </span>

            </div>


            <div
                class="status"
                id="movieStatus">
            </div>


            <p>

                <strong>
                    Genre:
                </strong>

                <span id="movieGenre">
                </span>

            </p>


            <p>

                <strong>
                    Language:
                </strong>

                <span id="movieLanguage">
                </span>

            </p>


            <p>

                <strong>
                    Duration:
                </strong>

                <span id="movieDuration">
                </span>

                minutes

            </p>


            <p>

                <strong>
                    Release Date:
                </strong>

                <span id="movieReleaseDate">
                </span>

            </p>


            <div class="movie-description">

                <h3>
                    Description
                </h3>

                <p id="movieDescription">
                </p>

            </div>

        </div>

    </div>


    <!-- ================= THEATRES ================= -->

    <div class="theatre-section">

        <h2>
            Theatres & Shows
        </h2>


        <div
            id="noShows"
            style="display:none;">

            No shows available for this movie.

        </div>


        <div id="theatreContainer">
        </div>

    </div>


    <script src="Scripts/movieDetails.js"></script>

</body>

</html>