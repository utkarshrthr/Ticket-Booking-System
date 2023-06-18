package com.utk.apps.main.service;

import com.utk.apps.main.entity.Booking;
import com.utk.apps.main.entity.Show;
import com.utk.apps.main.entity.ShowSeat;
import com.utk.apps.main.exception.ShowSeatNotAvailableException;
import com.utk.apps.main.repository.BookingRepository;
import com.utk.apps.main.repository.ShowRepository;
import com.utk.apps.main.repository.ShowSeatRepository;
import com.utk.apps.main.status.BookingStatus;
import com.utk.apps.main.status.SeatStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final BookingAmountCalculator bookingAmountCalculator;
    private final BookingRepository bookingRepository;

    public BookingService(ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingAmountCalculator bookingAmountCalculator, BookingRepository bookingRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingAmountCalculator = bookingAmountCalculator;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long showId, List<Long> showSeatIds) {
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            throw new IllegalArgumentException("Show Id not found");
        }
        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        updateSeatStatus(showSeats);

        showSeatRepository.saveAll(showSeats);

        Booking booking = generateBooking(show, showSeats);

        return bookingRepository.save(booking);
    }

    private void updateSeatStatus(List<ShowSeat> showSeats){
        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("Seat: "+ showSeat.getId() +" not available");
            }
            showSeat.setSeatStatus(SeatStatus.LOCKED);
        }
    }

    private Booking generateBooking(Show show, List<ShowSeat> showSeats){
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setAmount(bookingAmountCalculator.calculateBookingAmount(showSeats));
        //booking.setBookedBy();
        booking.setBookingTime(LocalDateTime.now());
        //booking.setPayments();
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        return booking;
    }
}
