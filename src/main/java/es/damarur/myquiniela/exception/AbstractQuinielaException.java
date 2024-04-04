package es.damarur.myquiniela.exception;

import java.util.LinkedHashMap;
import java.util.Map;

public class AbstractQuinielaException extends RuntimeException implements ErrorWithCode {

    private final transient QuinielaExceptionCode exceptionCode;
    private final transient Map<String, Object> additionalDetails = new LinkedHashMap<>();

    protected AbstractQuinielaException(QuinielaExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

    protected AbstractQuinielaException(QuinielaExceptionCode exceptionCode, Map<String, Object> args) {
        super(exceptionCode.formattedMessage(args.values()));
        this.exceptionCode = exceptionCode;
        this.additionalDetails.putAll(args);
    }
}
