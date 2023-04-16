package ru.practicum.ewm.controller.errors;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practicum.ewm.model.errors.BadRequestException;
import ru.practicum.ewm.model.errors.ConflictException;
import ru.practicum.ewm.model.errors.NotFoundException;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(final NotFoundException e) {
        log.warn("404 {}", e.getMessage(), e);
        return new ErrorResponse("Object not found 404", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleIncorrectParameterException(final ConflictException e) {
        log.warn("409 {}", e.getMessage(), e);
        return new ErrorResponse("No valid data", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.warn("404 {}", e.getMessage(), e);
        return new ErrorResponse("Object not available 400 ", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(final ConstraintViolationException e) {
        log.warn("404 {}", e.getMessage(), e);
        return new ErrorResponse("Object not available 400 ", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequestException(final BadRequestException e) {
        log.warn("404 {}", e.getMessage(), e);
        return new ErrorResponse("Object not available 400 ", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleIntegrityException(final DataAccessException e) {
        log.warn("409 {}", e.getMessage(), e);
        return new ErrorResponse("No valid data", e.getMessage());
    }
}
