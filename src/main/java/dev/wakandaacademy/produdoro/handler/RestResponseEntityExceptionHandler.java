package dev.wakandaacademy.produdoro.handler;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorApiResponse> handleGenericException(ApiException ex) {
        return ex.buildErrorResponseEntity();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApiResponse> handleGenericException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorApiResponse.builder()
                        .description("Erro interno do sistema")
                        .message("Por favor informar ao adminstrador do sistema!")
                        .build());
    }
}
