package com.processes.shop.exceptions;

import com.processes.shop.model.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.List;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> notFoundExceptionHandle(NotFoundException notFoundException){
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(notFoundException.getMessage()))
                        .statusCode(HttpStatus.NOT_FOUND.name())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Response> AlreadyExistsExceptionHandle(AlreadyExistsException alreadyExistsException){
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(alreadyExistsException.getMessage()))
                        .statusCode(HttpStatus.CONFLICT.name())
                        .build(),
                HttpStatus.CONFLICT
        );
    }
}

