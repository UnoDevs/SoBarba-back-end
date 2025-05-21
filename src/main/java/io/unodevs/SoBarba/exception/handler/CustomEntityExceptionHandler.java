package io.unodevs.SoBarba.exception.handler;

import io.unodevs.SoBarba.exception.EntityNotFoundException;
import io.unodevs.SoBarba.exception.ExceptionResponse;
import io.unodevs.SoBarba.exception.InvalidEntityResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse responseEx = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(responseEx, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleEntityNotFoundException(Exception ex, WebRequest request){
        ExceptionResponse responseEx = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(responseEx, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEntityResponseException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidEntityResponseException(Exception ex, WebRequest request){
        ExceptionResponse responseEx = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(responseEx, HttpStatus.BAD_REQUEST);
    }

}
