package com.oceanunity.app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ObjectAlreadyExistsException extends OceanUnityException{

    private String message;

    public ObjectAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle(message + "already exists!");

        return pb;
    }
}
