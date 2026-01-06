package carloschgas.cinematch.exceptions;

import carloschgas.cinematch.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserNameException.class)
    public ResponseEntity<ErrorDTO> handleInvalidUserName(InvalidUserNameException e){

        ErrorDTO error = new ErrorDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
}
