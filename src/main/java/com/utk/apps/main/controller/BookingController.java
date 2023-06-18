package com.utk.apps.main.controller;

import com.utk.apps.main.dto.BookingRequest;
import com.utk.apps.main.dto.BookingResponse;
import com.utk.apps.main.entity.Booking;
import com.utk.apps.main.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book-ticket")
    public ResponseEntity<Booking> bookTicket(@RequestBody BookingRequest request){
        Booking booking = bookingService.bookTicket(request.getShowId(), request.getShowSeatIds());
        return ResponseEntity.created(URI.create("/api/book-ticket")).body(booking);
    }
}
