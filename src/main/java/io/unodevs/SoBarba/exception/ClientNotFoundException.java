package io.unodevs.SoBarba.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
