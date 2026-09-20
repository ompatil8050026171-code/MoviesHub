// =====================================================
// GET BOOKING DATA FROM SESSION STORAGE
// =====================================================

let bookingData = sessionStorage.getItem("bookingData");


if (bookingData == null) {

    document.getElementById("loading").style.display = "none";

    document.getElementById("error").style.display = "block";

    document.getElementById("error").innerText =
        "No booking data found. Please select your seats again.";

}
else {

    try {

        bookingData = JSON.parse(bookingData);

        displayBooking();

    }
    catch (error) {

        console.error(error);

        document.getElementById("loading").style.display = "none";

        document.getElementById("error").style.display = "block";

        document.getElementById("error").innerText =
            "Unable to read booking details.";
    }
}


// =====================================================
// DISPLAY BOOKING
// =====================================================

function displayBooking() {

    document.getElementById("loading").style.display = "none";

    document.getElementById("checkoutContent").style.display = "grid";


    // ================= MOVIE =================

    document.getElementById("movieTitle").innerText =
        bookingData.movieTitle;


    // ================= THEATRE =================

    document.getElementById("theatreName").innerText =
        bookingData.theatreName;


    // ================= SCREEN =================

    document.getElementById("screenName").innerText =
        bookingData.screenName;


    // ================= DATE =================

    document.getElementById("showDate").innerText =
        bookingData.showDate;


    // ================= TIME =================

    document.getElementById("showTime").innerText =
        bookingData.showTime;


    // ================= SEATS =================

    displaySeats();


    // ================= SNACKS =================

    displaySnacks();


    // ================= TOTALS =================

    document.getElementById("seatTotal").innerText =
        bookingData.seatTotal;

    document.getElementById("snackTotal").innerText =
        bookingData.snackTotal;

    document.getElementById("grandTotal").innerText =
        bookingData.grandTotal;
}


// =====================================================
// DISPLAY SELECTED SEATS
// =====================================================

function displaySeats() {

    let seatList =
        document.getElementById("seatList");

    seatList.innerHTML = "";


    if (!bookingData.seats ||
        bookingData.seats.length === 0) {

        seatList.innerHTML =
            '<p class="empty">No seats selected</p>';

        return;
    }


    for (let i = 0; i < bookingData.seats.length; i++) {

        let seat =
            bookingData.seats[i];

        let seatBox =
            document.createElement("div");

        seatBox.className = "seat";

        seatBox.innerText =
            seat.seatNumber;

        seatList.appendChild(seatBox);
    }
}


// =====================================================
// DISPLAY SELECTED SNACKS
// =====================================================

function displaySnacks() {

    let snackList =
        document.getElementById("snackList");

    snackList.innerHTML = "";


    if (!bookingData.snacks ||
        bookingData.snacks.length === 0) {

        snackList.innerHTML =
            '<p class="empty">No snacks selected</p>';

        return;
    }


    for (let i = 0;
         i < bookingData.snacks.length;
         i++) {

        let snack =
            bookingData.snacks[i];

        let row =
            document.createElement("div");

        row.className = "snack-row";

        row.innerHTML =
            '<span class="snack-name">' +
            snack.name +
            '</span>' +

            '<span class="snack-quantity">' +
            'Qty: ' +
            snack.quantity +
            '</span>' +

            '<span class="snack-price">' +
            '&#8377;' +
            (snack.price * snack.quantity) +
            '</span>';

        snackList.appendChild(row);
    }
}


// =====================================================
// CONFIRM BOOKING
// =====================================================

function confirmBooking() {

    if (bookingData == null) {

        alert("Booking data not found.");

        return;
    }


    // ================= SEATS =================

    let seats = [];

    for (let i = 0;
         i < bookingData.seats.length;
         i++) {

        seats.push({

            seatId:
                bookingData.seats[i].seatId,

            price:
                bookingData.showPrice
        });
    }


    // ================= SNACKS =================

    let snacks = [];

    for (let i = 0;
         i < bookingData.snacks.length;
         i++) {

        snacks.push({

            snackId:
                bookingData.snacks[i].snackId,

            quantity:
                bookingData.snacks[i].quantity,

            price:
                bookingData.snacks[i].price
        });
    }


    // ================= REQUEST DATA =================

    let requestData = {

        showId:
            parseInt(bookingData.showId),

        grandTotal:
            parseFloat(bookingData.grandTotal),

        seats:
            seats,

        snacks:
            snacks
    };


    // ================= SEND TO BACKEND =================

    fetch("/confirmBooking", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body:
            JSON.stringify(requestData)

    })

    .then(response => {

        if (!response.ok) {

            throw new Error(
                "Booking could not be completed."
            );
        }

        return response.text();
    })

    .then(bookingId => {

        console.log(
            "Booking ID:",
            bookingId
        );


        sessionStorage.removeItem(
            "bookingData"
        );


        window.location.href =
            "bookingConfirmation.jsp";
    })

    .catch(error => {

        console.error(error);

        alert(
            "Booking could not be completed."
        );
    });
}


// =====================================================
// NAVIGATION
// =====================================================

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