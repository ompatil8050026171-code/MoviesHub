package com.Movie.utility.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.BookingItems;
import com.Movie.utility.Model.BookingRequest;
import com.Movie.utility.Model.Bookings;
import com.Movie.utility.Model.SeatRequest;
import com.Movie.utility.Model.Seats;
import com.Movie.utility.Model.Shows;
import com.Movie.utility.Model.SnackRequest;
import com.Movie.utility.Model.Snacks;
import com.Movie.utility.Model.User;
import com.Movie.utility.Repo.BookingItemsRepo;
import com.Movie.utility.Repo.BookingsRepo;
import com.Movie.utility.Repo.SeatsRepo;
import com.Movie.utility.Repo.ShowsRepo;
import com.Movie.utility.Repo.SnacksRepo;

import jakarta.transaction.Transactional;

@Service
public class BookingsService {

    @Autowired
    private BookingsRepo bookingsRepo;

    @Autowired
    private BookingItemsRepo bookingItemsRepo;

    @Autowired
    private ShowsRepo showsRepo;

    @Autowired
    private SeatsRepo seatsRepo;

    @Autowired
    private SnacksRepo snacksRepo;


    public void addBooking(Bookings booking) {
        bookingsRepo.save(booking);
    }


    public List<Bookings> getAllBookings() {
        return bookingsRepo.findAll();
    }


    public Optional<Bookings> getBookingById(int id) {
        return bookingsRepo.findById(id);
    }


    public List<Bookings> getBookingsByUserId(int userId) {
        return bookingsRepo.findByUserUserId(userId);
    }


    @Transactional
    public int confirmBooking(
            BookingRequest request,
            User user) {


        // -----------------------------
        // 1. FIND SHOW
        // -----------------------------

        Shows show = showsRepo
                .findById(request.getShowId())
                .orElseThrow(() ->
                    new RuntimeException(
                        "Show not found: "
                        + request.getShowId()
                    ));


        // -----------------------------
        // 2. CREATE BOOKING
        // -----------------------------

        Bookings booking = new Bookings();

        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingDate(new Date());
        booking.setTotal_amount(request.getGrandTotal());
        booking.setStatus("Confirmed");


        // -----------------------------
        // 3. SAVE BOOKING
        // -----------------------------

        Bookings savedBooking =
                bookingsRepo.save(booking);


        System.out.println(
            "BOOKING CREATED: "
            + savedBooking.getBookingId()
        );


        // -----------------------------
        // 4. SAVE SEATS
        // -----------------------------

        if (request.getSeats() != null) {

            for (SeatRequest seatRequest :
                    request.getSeats()) {


                Seats seat = seatsRepo
                        .findById(seatRequest.getSeatId())
                        .orElseThrow(() ->
                            new RuntimeException(
                                "Seat not found: "
                                + seatRequest.getSeatId()
                            ));


                BookingItems item =
                        new BookingItems();


                item.setBooking(savedBooking);

                item.setSeat(seat);

                item.setSnack(null);

                item.setQuantity(1);

                item.setPrice(
                    seatRequest.getPrice()
                );


                bookingItemsRepo.save(item);
            }
        }


        // -----------------------------
        // 5. SAVE SNACKS
        // -----------------------------

        if (request.getSnacks() != null) {

            for (SnackRequest snackRequest :
                    request.getSnacks()) {


                Snacks snack = snacksRepo
                        .findById(snackRequest.getSnackId())
                        .orElseThrow(() ->
                            new RuntimeException(
                                "Snack not found: "
                                + snackRequest.getSnackId()
                            ));


                BookingItems item =
                        new BookingItems();


                item.setBooking(savedBooking);

                item.setSeat(null);

                item.setSnack(snack);

                item.setQuantity(
                    snackRequest.getQuantity()
                );

                item.setPrice(
                    snackRequest.getPrice()
                );


                bookingItemsRepo.save(item);
            }
        }


        System.out.println(
            "BOOKING COMPLETED: "
            + savedBooking.getBookingId()
        );


        return savedBooking.getBookingId();
    }


    public void updateBooking(
            int id,
            Bookings booking) {

        Optional<Bookings> optional =
                bookingsRepo.findById(id);


        if (optional.isPresent()) {

            Bookings existing =
                    optional.get();


            if (booking.getUser() != null) {
                existing.setUser(
                    booking.getUser()
                );
            }


            if (booking.getShow() != null) {
                existing.setShow(
                    booking.getShow()
                );
            }


            if (booking.getBookingDate() != null) {
                existing.setBookingDate(
                    booking.getBookingDate()
                );
            }


            if (booking.getTotal_amount() != 0) {
                existing.setTotal_amount(
                    booking.getTotal_amount()
                );
            }


            if (booking.getStatus() != null) {
                existing.setStatus(
                    booking.getStatus()
                );
            }


            bookingsRepo.save(existing);
        }
    }


    public void deleteBooking(int id) {

        Optional<Bookings> optional =
                bookingsRepo.findById(id);


        if (optional.isPresent()) {

            bookingsRepo.delete(
                optional.get()
            );
        }
    }
}