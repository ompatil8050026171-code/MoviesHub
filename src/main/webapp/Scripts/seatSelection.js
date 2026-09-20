// =====================================================
// GET SHOW ID
// =====================================================

let params =
    new URLSearchParams(window.location.search);

let showId =
    params.get("id");


// =====================================================
// VARIABLES
// =====================================================

let showPrice = 0;

let selectedSeats = [];

let allSnacks = [];

let selectedSnacks = {};

let snackTotal = 0;

let currentShow = null;


// =====================================================
// START
// =====================================================

if (!showId) {

    document.getElementById("loading")
        .style.display = "none";

    document.getElementById("error")
        .innerText = "Show ID not found.";

}
else {

    loadShow();

    loadSnacks();

}


// =====================================================
// LOAD SHOW
// =====================================================

function loadShow() {

    fetch("/getShowById/" + showId)

        .then(response => {

            if (!response.ok) {

                throw new Error("Show not found");

            }

            return response.json();

        })

        .then(show => {

            // Store complete show object
            currentShow = show;

            showPrice = show.price;


            document.getElementById("loading")
                .style.display = "none";


            document.getElementById("showInfo")
                .style.display = "block";


            document.getElementById("movieTitle")
                .innerText =
                show.movie.title;


            document.getElementById("theatreName")
                .innerText =
                show.screen.theatre.theatreName;


            document.getElementById("screenName")
                .innerText =
                show.screen.screenName;


            document.getElementById("showDate")
                .innerText =
                show.showDate;


            document.getElementById("showTime")
                .innerText =
                show.startTime;


            document.getElementById("showPrice")
                .innerText =
                show.price;


            loadSeats(
                show.screen.screenId
            );

        })

        .catch(error => {

            console.error(error);

            document.getElementById("loading")
                .style.display = "none";

            document.getElementById("error")
                .innerText =
                "Unable to load show details.";

        });
}


// =====================================================
// LOAD SEATS
// =====================================================

function loadSeats(screenId) {

    fetch("/getSeatsByScreenId/" + screenId)

        .then(response => {

            if (!response.ok) {

                throw new Error("Seats not found");

            }

            return response.json();

        })

        .then(seats => {

            displaySeats(seats);

        })

        .catch(error => {

            console.error(error);

            document.getElementById("noSeats")
                .style.display = "block";

        });
}


// =====================================================
// DISPLAY SEATS
// =====================================================

function displaySeats(seats) {

    let container =
        document.getElementById("seatContainer");


    container.innerHTML = "";


    if (seats.length === 0) {

        document.getElementById("noSeats")
            .style.display = "block";

        return;

    }


    document.getElementById("noSeats")
        .style.display = "none";


    for (let i = 0; i < seats.length; i++) {

        let seat = seats[i];


        let button =
            document.createElement("button");


        button.className = "seat";


        button.innerText =
            seat.seatNumber;


        button.onclick =
            function() {

                selectSeat(
                    seat,
                    button
                );

            };


        container.appendChild(button);

    }
}


// =====================================================
// SELECT SEAT
// =====================================================

function selectSeat(seat, button) {

    let index =
        selectedSeats.findIndex(
            s => s.seatId === seat.seatId
        );


    if (index === -1) {

        selectedSeats.push(seat);

        button.classList.add("selected");

    }
    else {

        selectedSeats.splice(
            index,
            1
        );

        button.classList.remove("selected");

    }


    calculateTotal();

}


// =====================================================
// LOAD SNACKS
// =====================================================

function loadSnacks() {

    fetch("/getAllSnacks")

        .then(response => {

            if (!response.ok) {

                throw new Error("Snacks not found");

            }

            return response.json();

        })

        .then(snacks => {

            allSnacks = snacks;

            displaySnacks(snacks);

        })

        .catch(error => {

            console.error(error);

            document.getElementById("noSnacks")
                .style.display = "block";

        });
}


// =====================================================
// DISPLAY SNACKS
// =====================================================

function displaySnacks(snacks) {

    let container =
        document.getElementById("snackContainer");


    let toggleButton =
        document.getElementById("snackToggle");


    container.innerHTML = "";


    selectedSnacks = {};


    if (snacks.length === 0) {

        document.getElementById("noSnacks")
            .style.display = "block";

        toggleButton.style.display = "none";

        return;

    }


    document.getElementById("noSnacks")
        .style.display = "none";


    for (let i = 0; i < snacks.length; i++) {

        let snack = snacks[i];


        selectedSnacks[i] = 0;


        let card =
            document.createElement("div");


        card.className =
            "snack-card";


        // First 3 snacks visible
        // Remaining snacks hidden

        if (i >= 3) {

            card.classList.add(
                "hidden-snack"
            );

        }


        card.innerHTML =

            '<div class="snack-info">' +

                '<div class="snack-name">' +
                    snack.name +
                '</div>' +

                '<div class="snack-description">' +
                    snack.description +
                '</div>' +

                '<div class="snack-price">' +
                    '&#8377;' +
                    snack.price +
                '</div>' +

            '</div>' +


            '<div class="quantity-control">' +

                '<button onclick="decreaseSnack(' +
                    i +
                ')">' +
                    '-' +
                '</button>' +

                '<span class="quantity" id="snackQty' +
                    i +
                '">' +
                    '0' +
                '</span>' +

                '<button onclick="increaseSnack(' +
                    i +
                ')">' +
                    '+' +
                '</button>' +

            '</div>';


        container.appendChild(card);

    }


    if (snacks.length > 3) {

        toggleButton.style.display = "block";

        toggleButton.innerText =
            "View all snacks";

    }
    else {

        toggleButton.style.display = "none";

    }

}


// =====================================================
// TOGGLE SNACKS
// =====================================================

function toggleSnacks() {

    let extraSnacks =
        document.querySelectorAll(
            ".hidden-snack"
        );


    let button =
        document.getElementById("snackToggle");


    if (extraSnacks.length === 0) {
        return;
    }


    let showing =
        extraSnacks[0]
            .classList
            .contains("show-snack");


    for (
        let i = 0;
        i < extraSnacks.length;
        i++
    ) {

        if (showing) {

            extraSnacks[i]
                .classList
                .remove("show-snack");

        }
        else {

            extraSnacks[i]
                .classList
                .add("show-snack");

        }

    }


    if (showing) {

        button.innerText =
            "View all snacks";

    }
    else {

        button.innerText =
            "Hide snacks";

    }

}


// =====================================================
// INCREASE SNACK
// =====================================================

function increaseSnack(index) {

    selectedSnacks[index]++;


    document.getElementById(
        "snackQty" + index
    ).innerText =
        selectedSnacks[index];


    calculateSnackTotal();

}


// =====================================================
// DECREASE SNACK
// =====================================================

function decreaseSnack(index) {

    if (selectedSnacks[index] > 0) {

        selectedSnacks[index]--;

    }


    document.getElementById(
        "snackQty" + index
    ).innerText =
        selectedSnacks[index];


    calculateSnackTotal();

}


// =====================================================
// SNACK TOTAL
// =====================================================

function calculateSnackTotal() {

    snackTotal = 0;


    for (
        let i = 0;
        i < allSnacks.length;
        i++
    ) {

        snackTotal +=
            allSnacks[i].price *
            selectedSnacks[i];

    }


    calculateTotal();

}


// =====================================================
// GRAND TOTAL
// =====================================================

function calculateTotal() {

    let seatTotal =
        selectedSeats.length *
        showPrice;


    let grandTotal =
        seatTotal +
        snackTotal;


    document.getElementById("seatTotal")
        .innerText =
        seatTotal;


    document.getElementById("snackTotal")
        .innerText =
        snackTotal;


    document.getElementById("totalPrice")
        .innerText =
        grandTotal;

}


// =====================================================
// CONTINUE TO CHECKOUT
// =====================================================

function continueBooking() {

    // -----------------------------------------------
    // CHECK SEATS
    // -----------------------------------------------

    if (selectedSeats.length === 0) {

        alert(
            "Please select at least one seat."
        );

        return;

    }


    // -----------------------------------------------
    // CHECK SHOW
    // -----------------------------------------------

    if (currentShow === null) {

        alert(
            "Show details are still loading. Please try again."
        );

        return;

    }


    // -----------------------------------------------
    // SELECTED SNACKS
    // -----------------------------------------------

    let snacks = [];


    for (
        let i = 0;
        i < allSnacks.length;
        i++
    ) {

        if (selectedSnacks[i] > 0) {

            snacks.push({

                snackId:
                    allSnacks[i].snackId,

                name:
                    allSnacks[i].name,

                price:
                    allSnacks[i].price,

                quantity:
                    selectedSnacks[i]

            });

        }

    }


    // -----------------------------------------------
    // SEAT TOTAL
    // -----------------------------------------------

    let seatTotal =
        selectedSeats.length *
        showPrice;


    // -----------------------------------------------
    // GRAND TOTAL
    // -----------------------------------------------

    let grandTotal =
        seatTotal +
        snackTotal;


    // -----------------------------------------------
    // BOOKING DATA
    // -----------------------------------------------

    let bookingData = {

        showId:
            parseInt(showId),

        movieTitle:
            currentShow.movie.title,

        theatreName:
            currentShow.screen.theatre.theatreName,

        screenName:
            currentShow.screen.screenName,

        showDate:
            currentShow.showDate,

        showTime:
            currentShow.startTime,

        showPrice:
            showPrice,

        seats:
            selectedSeats,

        snacks:
            snacks,

        seatTotal:
            seatTotal,

        snackTotal:
            snackTotal,

        grandTotal:
            grandTotal

    };


    console.log(
        "Booking Data:",
        bookingData
    );


    // -----------------------------------------------
    // SAVE TO SESSION STORAGE
    // -----------------------------------------------

    sessionStorage.setItem(
        "bookingData",
        JSON.stringify(bookingData)
    );


    // -----------------------------------------------
    // GO TO CHECKOUT
    // -----------------------------------------------

    window.location.href =
        "Checkout.jsp";

}


// =====================================================
// NAVIGATION
// =====================================================

function goToHome() {

    window.location.href =
        "home.jsp";

}


function goToHistory() {

    window.location.href =
        "bookingHistory.jsp";

}


function goToProfile() {

    window.location.href =
        "Profile.jsp";

}


function logout() {

    window.location.href =
        "logout";

}