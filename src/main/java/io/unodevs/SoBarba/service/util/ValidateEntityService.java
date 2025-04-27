package io.unodevs.SoBarba.service.util;

import io.unodevs.SoBarba.exception.EntityNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateEntityService {

    public static <T> T validateOptional(Optional<T> opt){
        if(opt.isPresent()){
            return opt.get();
        }
        throw new EntityNotFoundException("Entity searched not found!");
    }

    public static <T> T validateOptional(Optional<T> opt, Class<T> cls){
        if(opt.isPresent()){
            return opt.get();
        }
        throw new EntityNotFoundException(cls.getSimpleName() + " searched not found!");
    }
}
