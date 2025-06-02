package io.unodevs.SoBarba.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidEntityRequestException extends RuntimeException {
    public InvalidEntityRequestException(String message) {
        super(message);
    }
}
