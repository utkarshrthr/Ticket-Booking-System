package com.utk.apps.main.service;

import com.utk.apps.main.entity.Show;
import com.utk.apps.main.entity.ShowSeat;
import com.utk.apps.main.entity.ShowSeatPricing;
import com.utk.apps.main.repository.ShowSeatPricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingAmountCalculator {

    @Autowired
    private ShowSeatPricingRepository showSeatPricingRepository;

    public double calculateBookingAmount(List<ShowSeat> showSeats){
        Show show = showSeats.get(0).getShow();

        List<ShowSeatPricing> showSeatPricing = showSeatPricingRepository.findByShowEquals(show);

        double amount =  0;

        for(ShowSeat showSeat: showSeats){
            for(ShowSeatPricing pricing: showSeatPricing){
                if (showSeat.getSeat().getSeatType().equals(pricing.getSeatType()))
                    amount += pricing.getAmount();
            }
        }
        return amount;
    }
}
