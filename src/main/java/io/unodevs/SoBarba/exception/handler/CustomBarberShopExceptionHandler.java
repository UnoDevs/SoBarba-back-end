package io.unodevs.SoBarba.exception.handler;

import io.unodevs.SoBarba.controller.BarberShopController;
import io.unodevs.SoBarba.exception.BarberShopNotFoundException;
import io.unodevs.SoBarba.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
@ControllerAdvice(assignableTypes = BarberShopController.class)
public class CustomBarberShopExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleExceptions(Exception ex, WebRequest request) {
        ExceptionResponse responseEx = new ExceptionResponse(
          new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(responseEx, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BarberShopNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleBarberShopNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse responseEx = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(responseEx, HttpStatus.BAD_REQUEST);
    }
}
