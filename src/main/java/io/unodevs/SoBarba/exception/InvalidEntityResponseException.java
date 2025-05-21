package io.unodevs.SoBarba.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidEntityResponseException extends RuntimeException {
    public InvalidEntityResponseException(String message) {
        super(message);
    }
}
