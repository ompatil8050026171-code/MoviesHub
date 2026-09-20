package com.Movie.utility.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Movie.utility.Model.BookingItems;
import com.Movie.utility.Service.BookingItemsService;

@RestController
public class BookingItemsController {

    @Autowired
    private BookingItemsService bookingItemsService;

    @GetMapping("/addBookingItem")
    public void addBookingItem(@RequestBody BookingItems bookingItem) {
        bookingItemsService.addBookingItem(bookingItem);
    }

    @GetMapping("/getAllBookingItems")
    public List<BookingItems> getAllBookingItems() {
        return bookingItemsService.getAllBookingItems();
    }

    @GetMapping("/getBookingItemById/{id}")
    public Optional<BookingItems> getBookingItemById(@PathVariable int id) {
        return bookingItemsService.getBookingItemById(id);
    }

    // Extra method
    @GetMapping("/getBookingItemsByBookingId/{bookingId}")
    public List<BookingItems> getBookingItemsByBookingId(@PathVariable int bookingId) {
        return bookingItemsService.getBookingItemsByBookingId(bookingId);
    }

    @PutMapping("/updateBookingItem/{id}")
    public void updateBookingItem(@PathVariable int id,
                                  @RequestBody BookingItems bookingItem) {
        bookingItemsService.updateBookingItem(id, bookingItem);
    }

    @DeleteMapping("/deleteBookingItem/{id}")
    public void deleteBookingItem(@PathVariable int id) {
        bookingItemsService.deleteBookingItem(id);
    }
}