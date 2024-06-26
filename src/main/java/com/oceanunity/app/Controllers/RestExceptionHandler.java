package com.oceanunity.app.Controllers;

import com.oceanunity.app.Exceptions.OceanUnityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(OceanUnityException.class)
    public ProblemDetail handleOceanUnityException(OceanUnityException exception){
        return exception.toProblemDetail();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidExcpetion(MethodArgumentNotValidException e){
        var fieldErrors = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Your request parameters didn't validate");
        pb.setProperty("Invalid Params", fieldErrors);
        return pb;
    }
    private record InvalidParam(String fieldName, String reason){};
}
