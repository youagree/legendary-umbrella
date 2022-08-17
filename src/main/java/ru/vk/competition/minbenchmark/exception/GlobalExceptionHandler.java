package ru.vk.competition.minbenchmark.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public void handleRfidAccessDeniedException(Exception ex) {
       log.info("exception from EXCEPTION HANDLER " + ex.getMessage(), ex.getCause(), ex.getStackTrace());
    }

    @ExceptionHandler({NotAcceptException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public void handleRfidAccessDeniedException(NotAcceptException ex) {
        log.info("exception from EXCEPTION HANDLER " + ex.getMessage(), ex.getCause(), ex.getStackTrace());
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleRfidAccessDeniedException(BadRequestException ex) {
        log.info("exception from EXCEPTION HANDLER " + ex.getMessage(), ex.getCause(), ex.getStackTrace());
    }

    @ExceptionHandler({InternalServerErrorException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleRfidAccessDeniedException(InternalServerErrorException ex) {
        log.info("exception from EXCEPTION HANDLER " + ex.getMessage(), ex.getCause(), ex.getStackTrace());
    }

    @ExceptionHandler({AddNewQueryResultException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleRfidAccessDeniedException(AddNewQueryResultException ex) {
        log.info("exception from EXCEPTION HANDLER " + ex.getMessage(), ex.getCause(), ex.getStackTrace());
    }

}
