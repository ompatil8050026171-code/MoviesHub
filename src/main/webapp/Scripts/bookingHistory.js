/* =========================
   LOAD BOOKINGS
========================= */

function loadBookings() {

    fetch("/getBookingsByUserId/" + userId)

        .then(function(response) {

            if (!response.ok) {
                throw new Error("Unable to load bookings");
            }

            return response.json();

        })

        .then(function(bookings) {

            document.getElementById("loading")
                .style.display = "none";

            if (bookings.length === 0) {

                document.getElementById("bookingContainer")
                    .innerHTML =
                    "<div class='loading'>No bookings found.</div>";

                return;
            }

            displayBookings(bookings);

        })

        .catch(function(error) {

            console.error(error);

            document.getElementById("loading")
                .style.display = "none";

            document.getElementById("error")
                .innerText =
                "Unable to load booking history.";

        });
}


/* =========================
   DISPLAY BOOKINGS
========================= */

function displayBookings(bookings) {

    let container =
        document.getElementById("bookingContainer");

    container.innerHTML = "";


    bookings.forEach(function(booking) {

        let card =
            document.createElement("div");

        card.className = "booking-card";


        /* =========================
           BOOKING HEADER
        ========================= */

        let header =
            document.createElement("div");

        header.className = "booking-header";


        let left =
            document.createElement("div");

        left.innerHTML =

            "<div class='movie-name'>" +

            (booking.show.movie.title || "Movie") +

            "</div>" +

            "<div class='theatre-name'>" +

            (booking.show.screen.theatre.theatreName ||
                "Theatre") +

            "</div>" ;


        let right =
            document.createElement("div");

        right.innerHTML =

            "<div class='status'>" +

            (booking.status || "Confirmed") +

            "</div>";


        header.appendChild(left);

        header.appendChild(right);


        /* =========================
           DROPDOWN BUTTON
        ========================= */

        let button =
            document.createElement("button");

        button.className = "dropdown-btn";

        button.innerHTML =
            "▼ &nbsp; View Booking Details";


        /* =========================
           DETAILS AREA
        ========================= */

        let details =
            document.createElement("div");

        details.className =
            "booking-details";


        /* =========================
           BASIC INFORMATION
        ========================= */

        let info =
            document.createElement("div");

        info.className = "info-grid";


        info.innerHTML =

            "<div class='info-box'>" +

                "<div class='info-label'>Theatre</div>" +

                "<div class='info-value'>" +

                    booking.show.screen.theatre.theatreName +

                "</div>" +

            "</div>" +


            "<div class='info-box'>" +

                "<div class='info-label'>Screen</div>" +

                "<div class='info-value'>" +

                    booking.show.screen.screenName +

                "</div>" +

            "</div>" +


            "<div class='info-box'>" +

                "<div class='info-label'>Date</div>" +

                "<div class='info-value'>" +

                    booking.show.showDate +

                "</div>" +

            "</div>" +


            "<div class='info-box'>" +

                "<div class='info-label'>Time</div>" +

                "<div class='info-value'>" +

                    booking.show.startTime +

                "</div>" +

            "</div>";


        details.appendChild(info);


        /* =========================
           ITEMS AREA
        ========================= */

        let itemsArea =
            document.createElement("div");

        itemsArea.innerHTML =
            "<div class='loading'>" +
            "Loading seats and snacks..." +
            "</div>";

        details.appendChild(itemsArea);


        /* =========================
           TOTAL
        ========================= */

        let total =
            document.createElement("div");

        total.className = "total";

        total.innerHTML =

            "<span>Total Amount</span>" +

            "<span>&#8377; " +

            booking.total_amount +

            "</span>";


        details.appendChild(total);


        /* =========================
           DROPDOWN CLICK
        ========================= */

        button.addEventListener("click", function() {

            if (details.classList.contains("show")) {

                details.classList.remove("show");

                button.innerHTML =
                    "▼ &nbsp; View Booking Details";

            } else {

                details.classList.add("show");

                button.innerHTML =
                    "▲ &nbsp; Hide Booking Details";


                /* =========================
                   LOAD ITEMS ONLY ONCE
                ========================= */

                if (!details.dataset.loaded) {

                    loadBookingItems(
                        booking.bookingId,
                        itemsArea
                    );

                    details.dataset.loaded = "true";
                }

            }

        });


        card.appendChild(header);

        card.appendChild(button);

        card.appendChild(details);

        container.appendChild(card);

    });

}


/* =========================
   LOAD BOOKING ITEMS
========================= */

function loadBookingItems(bookingId, area) {

    fetch(
        "/getBookingItemsByBookingId/" +
        bookingId
    )

    .then(function(response) {

        if (!response.ok) {

            throw new Error(
                "Items not found"
            );
        }

        return response.json();

    })

    .then(function(items) {

        area.innerHTML = "";


        /* =========================
           SEATS
        ========================= */

        let seats =
            items.filter(function(item) {

                return item.seat != null;

            });


        /* =========================
           SNACKS
        ========================= */

        let snacks =
            items.filter(function(item) {

                return item.snack != null;

            });


        /* =========================
           SEAT SECTION
        ========================= */

        let seatTitle =
            document.createElement("div");

        seatTitle.className =
            "section-title";

        seatTitle.innerText =
            "🎟 Selected Seats";

        area.appendChild(seatTitle);


        if (seats.length === 0) {

            let noSeats =
                document.createElement("div");

            noSeats.innerText =
                "No seats found.";

            area.appendChild(noSeats);

        } else {

            seats.forEach(function(item) {

                let div =
                    document.createElement("div");

                div.className = "item";

                div.innerHTML =

                    "<span>" +

                    "Seat " +

                    item.seat.seatNumber +

                    "</span>" +

                    "<span>&#8377; " +

                    item.price +

                    "</span>";

                area.appendChild(div);

            });

        }


        /* =========================
           SNACK SECTION
        ========================= */

        let snackTitle =
            document.createElement("div");

        snackTitle.className =
            "section-title";

        snackTitle.innerText =
            "🍿 Snacks";

        area.appendChild(snackTitle);


        if (snacks.length === 0) {

            let noSnacks =
                document.createElement("div");

            noSnacks.innerText =
                "No snacks selected.";

            area.appendChild(noSnacks);

        } else {

            snacks.forEach(function(item) {

                let div =
                    document.createElement("div");

                div.className = "item";

                div.innerHTML =

                    "<span>" +

                    item.snack.name +

                    " × " +

                    item.quantity +

                    "</span>" +

                    "<span>&#8377; " +

                    (item.price * item.quantity) +

                    "</span>";

                area.appendChild(div);

            });

        }

    })

    .catch(function(error) {

        console.error(error);

        area.innerHTML =

            "<div class='error'>" +

            "Unable to load booking items." +

            "</div>";

    });

}


/* =========================
   START
========================= */

loadBookings();