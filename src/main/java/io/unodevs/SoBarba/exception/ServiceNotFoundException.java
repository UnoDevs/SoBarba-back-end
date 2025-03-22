package io.unodevs.SoBarba.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(String message) {
        super(message);
    }
}
