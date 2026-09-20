<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Booking Confirmed - MoviesHub</title>

    <link rel="stylesheet"
          href="/CSS/bookingConfirmation.css">

</head>

<body>

<div class="confirmation-container">


    <!-- BLAST FROM LEFT -->

    <span class="blast left-blast"
          style="--x:-80px; --y:20px;"></span>

    <span class="blast left-blast"
          style="--x:40px; --y:-100px;"></span>

    <span class="blast left-blast"
          style="--x:120px; --y:-50px;"></span>

    <span class="blast left-blast"
          style="--x:180px; --y:-150px;"></span>

    <span class="blast left-blast"
          style="--x:250px; --y:20px;"></span>


    <!-- BLAST FROM RIGHT -->

    <span class="blast right-blast"
          style="--x:80px; --y:20px;"></span>

    <span class="blast right-blast"
          style="--x:-40px; --y:-100px;"></span>

    <span class="blast right-blast"
          style="--x:-120px; --y:-50px;"></span>

    <span class="blast right-blast"
          style="--x:-180px; --y:-150px;"></span>

    <span class="blast right-blast"
          style="--x:-250px; --y:20px;"></span>


    <!-- SPARKLES -->

    <div class="sparkles">

        <span class="sparkle"
              style="left:5%; animation-delay:3.1s;"></span>

        <span class="sparkle"
              style="left:12%; animation-delay:3.5s;"></span>

        <span class="sparkle"
              style="left:20%; animation-delay:3.8s;"></span>

        <span class="sparkle"
              style="left:28%; animation-delay:3.2s;"></span>

        <span class="sparkle"
              style="left:36%; animation-delay:4s;"></span>

        <span class="sparkle"
              style="left:44%; animation-delay:3.6s;"></span>

        <span class="sparkle"
              style="left:52%; animation-delay:3.3s;"></span>

        <span class="sparkle"
              style="left:60%; animation-delay:4.1s;"></span>

        <span class="sparkle"
              style="left:68%; animation-delay:3.7s;"></span>

        <span class="sparkle"
              style="left:76%; animation-delay:3.4s;"></span>

        <span class="sparkle"
              style="left:84%; animation-delay:4.2s;"></span>

        <span class="sparkle"
              style="left:92%; animation-delay:3.9s;"></span>

    </div>


    <!-- CONFIRMATION -->

    <div class="confirmation-box">

        <div class="check-circle">
            ✓
        </div>

        <h1>
            Booking Completed!
        </h1>

        <p>
            Your movie tickets have been booked successfully.
        </p>

        <div class="buttons">

            <button class="history-btn"
                    onclick="goToHistory()">
                Booking History
            </button>

            <button class="movies-btn"
                    onclick="goToMovies()">
                Back to Movies
            </button>

        </div>

    </div>

</div>


<script src="/Scripts/bookingConfirmation.js"></script>

</body>

</html>