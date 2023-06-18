package com.utk.apps.main.exception;

import com.utk.apps.main.dto.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ShowSeatNotAvailableException.class)
    public ResponseEntity<BookingResponse> handleShowSeatNotAvailableException(ShowSeatNotAvailableException ex){
        return null;
    }
}
