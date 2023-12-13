package com.surajnarayanraut.mlm.advice;

import com.surajnarayanraut.mlm.dto.MsgResp;
import com.surajnarayanraut.mlm.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationAdvice {

    @ExceptionHandler({ValidationException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    MsgResp handleValidation(ValidationException exception) {
        return new MsgResp(exception.getMessage());
    }
}