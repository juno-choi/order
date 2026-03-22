package com.simol.order.common.exception;

import com.simol.order.common.exception.dto.ErrorResponse;
import jakarta.persistence.PessimisticLockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        final List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        final ObjectError objectError = allErrors.get(0);
        final String defaultMessage = objectError.getDefaultMessage();

        log.error("MethodArgumentNotValidException [code : BAD_REQUEST] [message : {}]", defaultMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.of("BAD_REQUEST", defaultMessage));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(final HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException [message : {}]", "body 값이 비어있습니다.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.of("BAD_REQUEST", "body 값이 비어있습니다."));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlePessimisticLockException(final PessimisticLockException e) {
        log.error("PessimisticLockException [message : {}]", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse.of("LOCK_TIMEOUT", "요청이 많아 처리할 수 없습니다. 잠시 후 다시 시도해주세요."));
    }
}
