package com.Movie.utility.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.BookingItems;
import com.Movie.utility.Repo.BookingItemsRepo;

@Service
public class BookingItemsService {

    @Autowired
    private BookingItemsRepo bookingItemsRepo;

    public void addBookingItem(BookingItems bookingItem) {
        bookingItemsRepo.save(bookingItem);
    }

    public List<BookingItems> getAllBookingItems() {
        return bookingItemsRepo.findAll();
    }

    public Optional<BookingItems> getBookingItemById(int id) {
        return bookingItemsRepo.findById(id);
    }

    
    public List<BookingItems> getBookingItemsByBookingId(int bookingId) {
        return bookingItemsRepo.findByBookingBookingId(bookingId);
    }

    public void updateBookingItem(int id, BookingItems bookingItem) {

        if (bookingItemsRepo.findById(id).isPresent()) {

            BookingItems existingBookingItem = bookingItemsRepo.findById(id).get();

            if (bookingItem.getBooking() != null) {
                existingBookingItem.setBooking(bookingItem.getBooking());
            }

            if (bookingItem.getSeat() != null) {
                existingBookingItem.setSeat(bookingItem.getSeat());
            }

            if (bookingItem.getSnack() != null) {
                existingBookingItem.setSnack(bookingItem.getSnack());
            }

            if (bookingItem.getQuantity() != 0) {
                existingBookingItem.setQuantity(bookingItem.getQuantity());
            }

            if (bookingItem.getPrice() != 0) {
                existingBookingItem.setPrice(bookingItem.getPrice());
            }

            bookingItemsRepo.save(existingBookingItem);
        }
    }

    public void deleteBookingItem(int id) {

        if (bookingItemsRepo.findById(id).isPresent()) {

            BookingItems bookingItem = bookingItemsRepo.findById(id).get();

            bookingItemsRepo.delete(bookingItem);
        }
    }
}