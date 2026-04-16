package edu.secourse.patientportal.pmbackend.exception;

import org.springframework.http.HttpStatus;

public class InvalidInputException extends APIException {
    public InvalidInputException(String msg){
        super(msg, HttpStatus.BAD_REQUEST.value());
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, HttpStatus.BAD_REQUEST.value(), cause);
    }
}
