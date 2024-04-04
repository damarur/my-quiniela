package es.damarur.myquiniela.exception;

import org.springframework.http.HttpStatus;

import java.util.IllegalFormatException;

public interface QuinielaExceptionCode {

    String getCode();

    HttpStatus getHttpStatus();

    String getMessage();

    default String formattedMessage(Object... args) {
        try {
            return String.format(getMessage(), args);
        } catch (IllegalFormatException e) {
            return getMessage();
        }
    }
}
