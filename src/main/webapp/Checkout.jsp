<%@ page import="com.Movie.utility.Model.User" %>

<%
    User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout - MoviesHub</title>

    <link rel="stylesheet" href="CSS/checkout.css">
</head>

<body>

    <!-- ================= NAVBAR ================= -->

    <div class="navbar">

        <div class="logo">
            MoviesHub
        </div>

        <div class="nav-buttons">

            <%
                if (user != null) {
            %>

                <button class="nav-btn" onclick="goToHome()">
                    Home
                </button>

                <button class="nav-btn" onclick="goToBookingHistory()">
                    Booking History
                </button>

                <button class="nav-btn" onclick="goToProfile()">
                    Profile
                </button>

                <button class="logout-btn" onclick="logout()">
                    Logout
                </button>

            <%
                } else {
            %>

                <button class="login-btn" onclick="goToLogin()">
                    Login
                </button>

                <button class="register-btn" onclick="goToRegister()">
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


    <!-- ================= MAIN ================= -->

    <div class="page-container">

        <h1 class="page-title">
            Checkout
        </h1>


        <div id="loading">
            Loading booking details...
        </div>


        <div id="error"></div>


        <div
            class="checkout-layout"
            id="checkoutContent"
            style="display:none;"
        >

            <!-- ================= LEFT SIDE ================= -->

            <div>

                <!-- MOVIE DETAILS -->

                <div class="details-box">

                    <h2>
                        Movie Details
                    </h2>

                    <div
                        class="movie-title"
                        id="movieTitle">
                    </div>

                    <div class="info">
                        Theatre:
                        <span id="theatreName"></span>
                    </div>

                    <div class="info">
                        Screen:
                        <span id="screenName"></span>
                    </div>

                    <div class="info">
                        Date:
                        <span id="showDate"></span>
                    </div>

                    <div class="info">
                        Time:
                        <span id="showTime"></span>
                    </div>

                </div>


                <!-- SELECTED SEATS -->

                <div class="details-box">

                    <h2>
                        Selected Seats
                    </h2>

                    <div
                        id="seatList"
                        class="seat-list">
                    </div>

                </div>


                <!-- SELECTED SNACKS -->

                <div class="details-box">

                    <h2>
                        Selected Snacks
                    </h2>

                    <div id="snackList">
                    </div>

                </div>

            </div>


            <!-- ================= RIGHT SIDE ================= -->

            <div class="summary-box">

                <h2>
                    Price Summary
                </h2>


                <div class="summary-row">

                    <span>
                        Seats
                    </span>

                    <span>
                        &#8377;<span id="seatTotal">0</span>
                    </span>

                </div>


                <div class="summary-row">

                    <span>
                        Snacks
                    </span>

                    <span>
                        &#8377;<span id="snackTotal">0</span>
                    </span>

                </div>


                <div class="grand-total">

                    <span>
                        Total
                    </span>

                    <span>
                        &#8377;<span id="grandTotal">0</span>
                    </span>

                </div>


                <button
                    class="confirm-btn"
                    onclick="confirmBooking()">

                    Confirm Booking

                </button>

            </div>

        </div>

    </div>


    <script src="Scripts/checkout.js"></script>

</body>
</html>