package com.utk.apps.main.dto;

import com.utk.apps.main.entity.Booking;
import com.utk.apps.main.status.BookingStatus;

public class BookingResponse {

    private Booking booking;
    private BookingStatus status;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
