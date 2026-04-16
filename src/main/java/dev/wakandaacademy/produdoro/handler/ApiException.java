package dev.wakandaacademy.produdoro.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Log4j2
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    HttpStatusCode statusException;
    private ErrorApiResponse bodyException;

    private ApiException(HttpStatusCode statusException, String message, Exception e) {
        this.statusException = statusException;
        this.bodyException = bodyException.builder()
                .message(message)
                .description(getDescription(e))
                .build();
    }

    private ApiException build(HttpStatusCode statusException, String message, Exception e) {
        log.error("Exception: ", e);
        return new ApiException(statusException, message, e);
    }

    private ApiException build(HttpStatusCode statusException, String message) {
        return new ApiException(statusException, message, null);
    }

    private String getDescription(Exception e) {
        return Optional.ofNullable(e)
                .map(ApiException::getMessageCause)
                .orElse(null);
    }

    private static String getMessageCause(Exception e) {
        return e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
    }

    public ResponseEntity<ErrorApiResponse> buildErrorResponseEntity() {
        return ResponseEntity
                .status(statusException)
                .body(bodyException);
    }
}
