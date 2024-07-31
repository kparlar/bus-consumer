package com.kparlar.iett.consumer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ErrorHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler implements ErrorHandler {
    

    @ExceptionHandler({RuntimeException.class})
    public void handleError(Throwable t) {
        log.error("Error occured: ", t.toString());
    }
}
