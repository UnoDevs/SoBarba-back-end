package io.unodevs.SoBarba.exception.handler;

import io.unodevs.SoBarba.controller.TaskController;
import io.unodevs.SoBarba.exception.ExceptionResponse;
import io.unodevs.SoBarba.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice(assignableTypes = TaskController.class)
public class CustomTaskExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse responseEx = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(responseEx, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleTaskNotFoundException(Exception ex, WebRequest request){
        ExceptionResponse responseEx = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(responseEx, HttpStatus.BAD_REQUEST);
    }
}
