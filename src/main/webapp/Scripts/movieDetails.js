// ==========================================
// MOVIE SLIDER
// ==========================================

let currentSlide = 0;

let slides =
    document.querySelectorAll(".slide");


setInterval(function() {

    slides[currentSlide]
        .classList.remove("active");

    currentSlide++;


    if (currentSlide >= slides.length) {

        currentSlide = 0;

    }


    slides[currentSlide]
        .classList.add("active");

}, 3000);


// ==========================================
// GET MOVIE ID FROM URL
// ==========================================

let urlParams =
    new URLSearchParams(
        window.location.search
    );

let movieId =
    urlParams.get("id");


if (!movieId) {

    document.getElementById(
        "loading"
    ).style.display = "none";

    document.getElementById(
        "error"
    ).innerText =
        "Movie ID not found.";

}
else {

    loadMovie();

    loadShows();

}


// ==========================================
// LOAD MOVIE DETAILS
// ==========================================

function loadMovie() {

    fetch("/getMovieById/" + movieId)

        .then(response => {

            if (!response.ok) {

                throw new Error(
                    "Movie not found"
                );

            }

            return response.json();

        })

        .then(movie => {

            document.getElementById(
                "loading"
            ).style.display = "none";


            document.getElementById(
                "movieDetails"
            ).style.display = "flex";


            // ==============================
            // MOVIE DATA
            // ==============================

            document.getElementById(
                "movieImage"
            ).src =
                "MovieImages/" +
                movie.image;


            document.getElementById(
                "movieTitle"
            ).innerText =
                movie.title;


            document.getElementById(
                "movieRating"
            ).innerText =
                movie.rating;


            document.getElementById(
                "movieStatus"
            ).innerText =
                movie.status;


            document.getElementById(
                "movieGenre"
            ).innerText =
                movie.genre;


            document.getElementById(
                "movieLanguage"
            ).innerText =
                movie.language;


            document.getElementById(
                "movieDuration"
            ).innerText =
                movie.duration;


            document.getElementById(
                "movieReleaseDate"
            ).innerText =
                movie.realseDate;


            document.getElementById(
                "movieDescription"
            ).innerText =
                movie.description;

        })


        .catch(error => {

            console.error(error);


            document.getElementById(
                "loading"
            ).style.display = "none";


            document.getElementById(
                "error"
            ).innerText =
                "Unable to load movie details.";

        });

}


// ==========================================
// LOAD SHOWS
// ==========================================

function loadShows() {

    fetch(
        "/getShowsByMovieId/" +
        movieId
    )

        .then(response => {

            if (!response.ok) {

                throw new Error(
                    "Shows not found"
                );

            }

            return response.json();

        })

        .then(shows => {

            displayTheatres(shows);

        })


        .catch(error => {

            console.error(error);

            document.getElementById(
                "noShows"
            ).style.display = "block";

        });

}


// ==========================================
// DISPLAY THEATRES
// ==========================================

function displayTheatres(shows) {

    let container =
        document.getElementById(
            "theatreContainer"
        );


    container.innerHTML = "";


    if (shows.length === 0) {

        document.getElementById(
            "noShows"
        ).style.display = "block";

        return;
    }


    // ==========================================
    // GROUP SHOWS BY THEATRE
    // ==========================================

    let theatres = {};


    for (
        let i = 0;
        i < shows.length;
        i++
    ) {

        let show = shows[i];

        let theatre =
            show.screen.theatre;


        let theatreId =
            theatre.theatreId;


        if (!theatres[theatreId]) {

            theatres[theatreId] = {

                theatre: theatre,

                shows: []

            };

        }


        theatres[theatreId]
            .shows
            .push(show);

    }


    // ==========================================
    // CREATE THEATRE CARDS
    // ==========================================

    for (
        let theatreId in theatres
    ) {

        let data =
            theatres[theatreId];


        let theatre =
            data.theatre;


        let card =
            document.createElement("div");


        card.className =
            "theatre-card";


        let html =

            '<div class="theatre-name">' +

                theatre.theatreName +

            '</div>' +


            '<div class="theatre-address">' +

                theatre.address +

            '</div>';


        let currentScreen = null;


        html +=
            '<div class="show-container">';


        // ==========================================
        // SHOWS
        // ==========================================

        for (
            let i = 0;
            i < data.shows.length;
            i++
        ) {

            let show =
                data.shows[i];


            // ==============================
            // SCREEN
            // ==============================

            if (
                currentScreen !==
                show.screen.screenId
            ) {

                if (
                    currentScreen !== null
                ) {

                    html +=
                        '</div>';

                }


                html +=

                    '<div class="screen-name">' +

                        show.screen.screenName +

                    '</div>' +

                    '<div class="show-container">';


                currentScreen =
                    show.screen.screenId;

            }


            // ==============================
            // SHOW BUTTON
            // ==============================

            html +=

                '<button class="show-btn" ' +

                'onclick="selectShow(' +
                show.showId +
                ')">' +

                    show.startTime +

                    '<span class="show-price">' +

                        '&#8377;' +

                        show.price +

                    '</span>' +

                '</button>';

        }


        html +=
            '</div>';


        card.innerHTML =
            html;


        container.appendChild(card);

    }

}


// ==========================================
// SELECT SHOW
// ==========================================

function selectShow(showId) {

    window.location.href =
        "seatSelection.jsp?id=" +
        showId;

}


// ==========================================
// NAVIGATION
// ==========================================

function goToHome() {

    window.location.href =
        "home.jsp";

}


function goToBookingHistory() {

    window.location.href =
        "bookingHistory.jsp";

}


function goToProfile() {

    window.location.href =
        "Profile.jsp";

}


function goToLogin() {

    window.location.href =
        "login.jsp";

}


function goToRegister() {

    window.location.href =
        "Register.jsp";

}


function logout() {

    window.location.href =
        "logout";

}