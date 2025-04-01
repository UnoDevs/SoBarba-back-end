package io.unodevs.SoBarba.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BarberShopNotFoundException extends RuntimeException {
    public BarberShopNotFoundException(String message) { super(message);}
}
