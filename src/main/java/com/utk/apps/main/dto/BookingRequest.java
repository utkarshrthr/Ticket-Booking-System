package com.utk.apps.main.dto;

import java.util.List;

public class BookingRequest {

    private Long showId;

    private List<Long> showSeatIds;

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public List<Long> getShowSeatIds() {
        return showSeatIds;
    }

    public void setShowSeatIds(List<Long> showSeatIds) {
        this.showSeatIds = showSeatIds;
    }
}
