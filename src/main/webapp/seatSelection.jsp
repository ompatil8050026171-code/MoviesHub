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

    <title>Select Seats - MoviesHub</title>

    <link rel="stylesheet" href="CSS/seatSelection.css">

</head>

<body>

    <!-- ================= NAVBAR ================= -->

    <div class="navbar">

        <div class="logo">
            MoviesHub
        </div>

        <div class="nav-buttons">

            <button
                class="nav-btn"
                onclick="goToHome()">
                Home
            </button>

            <button
                class="nav-btn"
                onclick="goToHistory()">
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

        <div id="loading">
            Loading show details...
        </div>

        <div id="error"></div>


        <!-- ================= SHOW DETAILS ================= -->

        <div
            class="show-info"
            id="showInfo"
            style="display:none;">

            <h1 id="movieTitle"></h1>

            <p>
                <strong>Theatre:</strong>
                <span id="theatreName"></span>
            </p>

            <p>
                <strong>Screen:</strong>
                <span id="screenName"></span>
            </p>

            <p>
                <strong>Date:</strong>
                <span id="showDate"></span>
            </p>

            <p>
                <strong>Time:</strong>
                <span id="showTime"></span>
            </p>

            <p>
                <strong>Price per seat:</strong>
                &#8377;<span id="showPrice"></span>
            </p>

        </div>


        <!-- ================= SEATS ================= -->

        <div class="seat-section">

            <h2>
                Select Your Seats
            </h2>

            <div class="screen">
                SCREEN
            </div>

            <div
                id="seatContainer"
                class="seat-container">
            </div>

            <div
                id="noSeats"
                style="display:none;">
                No seats available.
            </div>

        </div>


        <!-- ================= SNACKS ================= -->

        <div class="snack-section">

            <h2>
                Add Snacks
            </h2>

            <div id="snackContainer">
            </div>

            <button
                id="snackToggle"
                class="snack-toggle"
                onclick="toggleSnacks()"
                style="display:none;">

                View all snacks

            </button>

            <div
                id="noSnacks"
                style="display:none;">

                No snacks available.

            </div>

        </div>


        <!-- ================= TOTAL ================= -->

        <div class="total-section">

            <div class="total-row">

                <span>
                    Tickets Total
                </span>

                <span>
                    &#8377;<span id="seatTotal">0</span>
                </span>

            </div>


            <div class="total-row">

                <span>
                    Snacks Total
                </span>

                <span>
                    &#8377;<span id="snackTotal">0</span>
                </span>

            </div>


            <div class="total-row grand-total">

                <span>
                    Grand Total
                </span>

                <span>
                    &#8377;<span id="totalPrice">0</span>
                </span>

            </div>


            <button
                class="continue-btn"
                onclick="continueBooking()">

                Continue

            </button>

        </div>

    </div>


    <script src="Scripts/seatSelection.js"></script>

</body>

</html>