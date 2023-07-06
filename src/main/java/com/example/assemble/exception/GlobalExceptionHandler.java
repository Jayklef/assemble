package com.example.assemble.exception;

import com.example.assemble.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> ResourceNotFoundException(ResourceNotFoundException exception,
                                                                   WebRequest request){

        ErrorResponse error = new ErrorResponse();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(exception.getMessage());
        error.setTimestamp(new Date());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> MethodArgumentMismatch(MethodArgumentTypeMismatchException exception,
                                                                WebRequest request){
        ErrorResponse error = new ErrorResponse();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage(exception.getMessage());
        error.setTimestamp(new Date());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> ItemAlreadyExistsException(ItemAlreadyExistsException exception,
                                                                    WebRequest request){
        ErrorResponse error = new ErrorResponse();
        error.setStatusCode(HttpStatus.CONFLICT.value());
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage(exception.getMessage());
        error.setTimestamp(new Date());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> GeneralizedException(Exception ex,
                                                              WebRequest request){
        ErrorResponse error = new ErrorResponse();
        error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setMessage(ex.getMessage());
        error.setTimestamp(new Date());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
