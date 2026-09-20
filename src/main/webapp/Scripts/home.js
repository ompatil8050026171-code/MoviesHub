// ==============================
// NAVIGATION
// ==============================

function goToHome() {

    window.location.href = "home.jsp";
}


function goToBookingHistory() {

    window.location.href = "bookingHistory.jsp";
}


function goToProfile() {

    window.location.href = "Profile.jsp";
}


function goToLogin() {

    window.location.href = "login.jsp";
}


function goToRegister() {

    window.location.href = "Register.jsp";
}


function logout() {

    window.location.href = "logout";
}


// ==============================
// MOVIE DATA
// ==============================

let allMovies = [];


// ==============================
// GET ALL MOVIES
// ==============================

fetch("/getAllMovies")

    .then(response => {

        if (!response.ok) {

            throw new Error(
                "Failed to load movies"
            );

        }

        return response.json();

    })

    .then(movies => {

        allMovies = movies;

        document.getElementById(
            "loading"
        ).style.display = "none";

        displayMovies(movies);

    })

    .catch(error => {

        console.error(error);

        document.getElementById(
            "loading"
        ).style.display = "none";

        document.getElementById(
            "error"
        ).innerText =
            "Unable to load movies.";

    });


// ==============================
// DISPLAY MOVIES
// ==============================

function displayMovies(movies) {

    let container =
        document.getElementById(
            "movieContainer"
        );

    let noMovies =
        document.getElementById(
            "noMovies"
        );


    container.innerHTML = "";


    if (movies.length === 0) {

        noMovies.style.display = "block";

        return;
    }


    noMovies.style.display = "none";


    for (let i = 0;
         i < movies.length;
         i++) {

        let movie = movies[i];


        let card =
            document.createElement("div");


        card.className =
            "movie-card";


        card.innerHTML =

            '<img class="movie-image" ' +

            'src="MovieImages/' +
            movie.image +
            '" ' +

            'alt="' +
            movie.title +
            '">' +

            '<div class="movie-info">' +

                '<div class="movie-title">' +
                    movie.title +
                '</div>' +

                '<div class="movie-genre">' +
                    movie.genre +
                '</div>' +

                '<div class="movie-language">' +
                    movie.language +
                '</div>' +

                '<div class="movie-rating">' +
                    '&#9733; ' +
                    movie.rating +
                '</div>' +

                '<div class="movie-status">' +
                    movie.status +
                '</div>' +

            '</div>';


        // ==============================
        // MOVIE DETAILS
        // ==============================

        card.onclick = function() {

            window.location.href =
                "movieDetails.jsp?id=" +
                movie.movieId;

        };


        container.appendChild(card);

    }

}


// ==============================
// SEARCH MOVIES
// ==============================

document
    .getElementById("searchInput")
    .addEventListener(
        "keyup",
        function() {

            let searchValue =
                this.value
                    .toLowerCase()
                    .trim();


            if (searchValue === "") {

                displayMovies(allMovies);

                return;
            }


            let filteredMovies =
                allMovies.filter(
                    function(movie) {

                        return (

                            movie.title
                                .toLowerCase()
                                .includes(
                                    searchValue
                                )

                            ||

                            movie.genre
                                .toLowerCase()
                                .includes(
                                    searchValue
                                )

                            ||

                            movie.language
                                .toLowerCase()
                                .includes(
                                    searchValue
                                )

                        );

                    }
                );


            displayMovies(filteredMovies);

        }
    );