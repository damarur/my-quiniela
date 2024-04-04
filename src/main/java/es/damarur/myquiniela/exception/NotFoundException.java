package es.damarur.myquiniela.exception;

import es.damarur.myquiniela.domain.TeamId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.Map;

public class NotFoundException extends AbstractQuinielaException {

    private NotFoundException(QuinielaExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    private NotFoundException(QuinielaExceptionCode exceptionCode, Map<String, Object> args) {
        super(exceptionCode, args);
    }

    public static NotFoundException teamId(TeamId teamId) {
        Map<String, Object> args = new LinkedHashMap<>(1);
        args.put("teamId", teamId.getValue());
        return new NotFoundException(NotFoundExceptionCode.TEAM_ID_NOT_FOUND, args);
    }

    public static NotFoundException teamName(String teamName) {
        Map<String, Object> args = new LinkedHashMap<>(1);
        args.put("teamName", teamName);
        return new NotFoundException(NotFoundExceptionCode.TEAM_NAME_NOT_FOUND, args);
    }

    @AllArgsConstructor
    @Getter
    public enum NotFoundExceptionCode implements QuinielaExceptionCode {
        TEAM_ID_NOT_FOUND("TEAM_ID_NOT_FOUND", HttpStatus.NOT_FOUND, "Team with id %s was not found"),
        TEAM_NAME_NOT_FOUND("TEAM_NAME_NOT_FOUND", HttpStatus.NOT_FOUND, "Team with name %s was not found");

        private final String code;
        private final HttpStatus httpStatus;
        private final String message;
    }
}
